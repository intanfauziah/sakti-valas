package com.belajar.session.service;

import com.belajar.session.controller.SessionController;
import com.belajar.session.entity.bendahara.KasBankBenPeng;
import com.belajar.session.exception.BenException;
import com.belajar.session.repository.bendahara.KasBankBenPengRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Service
public class BendaharaService {
    @Autowired
    private KasBankBenPengRepository kasBankBenPengRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    public BigDecimal totalSaldoKasBankXtahun(String kodeSatker, String tahun, String unitTeknis) throws BenException {
        try {
            BigDecimal result;
            try {
                LOGGER.info("try service" + kodeSatker + tahun + unitTeknis);
                CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
                CriteriaQuery criteriaQuery = criteriaBuilder.createQuery(KasBankBenPeng.class);
                Root kasBankRoot = criteriaQuery.from(KasBankBenPeng.class);
                criteriaQuery.select(criteriaBuilder.sum(kasBankRoot.<BigDecimal> get("jumlah")));
                criteriaQuery.where(criteriaBuilder.and(
                        (criteriaBuilder.equal(kasBankRoot.get("kodeSatker"), kodeSatker )),
                        (criteriaBuilder.equal(kasBankRoot.get("kodeTahunAnggaran"), tahun )),
                        (criteriaBuilder.equal(kasBankRoot.get("kodeUnitTeknis"), unitTeknis ))
                        ));
                TypedQuery typedQuery = entityManager.createQuery(criteriaQuery);
                result = (BigDecimal) typedQuery.getSingleResult();
            } catch (NonUniqueResultException e) {
                LOGGER.info("catch nonunique");
                result = BigDecimal.ZERO;
            } catch (NoResultException e) {
                LOGGER.info("catch noresult");
                result = BigDecimal.ZERO;
            }
            LOGGER.info("result " + result);
            return result;
        } catch (Exception e) {
            LOGGER.info("catch exception");
            throw new BenException(e);
        }
    }

    public List<String> noSp2dExclude(String kodeSatker, String kodeTahunAnggaran) {
        LOGGER.info("req service " + kodeSatker + ", "+ kodeTahunAnggaran);
        List<String> sp2dExclude = new ArrayList<String>();
        List<KasBankBenPeng> hasil = kasBankBenPengRepository.findBank(kodeSatker, kodeTahunAnggaran);
        LOGGER.info("hasil " + hasil);
        if (hasil != null && !hasil.isEmpty()) {
            for (KasBankBenPeng kasBankBenPeng : hasil) {
                sp2dExclude.add(kasBankBenPeng.getNoSP2D());
            }
        }
        return sp2dExclude;
    }

}
