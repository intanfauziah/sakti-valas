package com.belajar.session.service;

import com.belajar.session.controller.SessionController;
import com.belajar.session.entity.valas.RekeningBendahara;
import com.belajar.session.entity.valas.Spp;
import com.belajar.session.repository.valas.RekeningBendaharaRepository;
import com.belajar.session.repository.valas.SppRepository;
import com.belajar.session.util.PaginationList;
import com.belajar.session.wrapper.RekeningBendaharaWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ValasService {
    @Autowired
    private SppRepository sppRepository;

    @Autowired
    private RekeningBendaharaRepository rekeningBendaharaRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    public List<Spp> getSpp(String kategoriKas, String kodeSatker){
        List<Spp> spp = new ArrayList<Spp>();
        LOGGER.info("kategoriKas "+kategoriKas);
        if(kategoriKas.equals("TUP")){
            LOGGER.info("tup");
            spp = sppRepository.findSppTup(kodeSatker);
        } else {
            LOGGER.info("up");
            spp = sppRepository.findSppUp(kodeSatker);
        }
        LOGGER.info("spp " + spp);
        return spp;
    }

    public List<RekeningBendahara> getRekBank(String kodeSatker) {
        List<RekeningBendahara> dataRekBank = new ArrayList<RekeningBendahara>();
        List<RekeningBendahara> rekBank = rekeningBendaharaRepository.findRekBank(kodeSatker);
        return rekBank;
    }

//    public List<RekeningBendaharaWrapper> getRekBank(String kodeSatker) {
//        List<RekeningBendaharaWrapper> dataRekBank = new ArrayList<RekeningBendaharaWrapper>();
//        List<Object[]> rekBank = rekeningBendaharaRepository.findRekBank(kodeSatker);
//        if (rekBank != null && !rekBank.isEmpty()) {
//            int index = 1;
//            for (Object[] objects : rekBank) {
//                RekeningBendaharaWrapper newwrapper = new RekeningBendaharaWrapper();
//                newwrapper.setIndex(index);
//                index++;
//                dataRekBank.add(newwrapper);
//            }
//        }
//        return dataRekBank;
//    }

    private RekeningBendaharaWrapper toWrapper(RekeningBendahara entity) {
        RekeningBendaharaWrapper wrapper = new RekeningBendaharaWrapper();
        wrapper.setId(entity.getId());
        wrapper.setCreatedBy(entity.getCreatedBy().equals(null) ? null : entity.getCreatedBy());
        wrapper.setCreatedDate(entity.getCreatedDate().equals(null) ? null : entity.getCreatedDate());
        wrapper.setDeleted(entity.getDeleted().equals(null) ? null : entity.getDeleted());
        wrapper.setModifiedBy(entity.getModifiedBy().equals(null) ? null : entity.getModifiedBy());
        wrapper.setModifiedDate(entity.getModifiedDate().equals(null) ? null : entity.getModifiedDate());
        wrapper.setVersion(entity.getVersion().equals(null) ? null : entity.getVersion());
        wrapper.setKode(entity.getKode().equals(null) ? null : entity.getKode());
        wrapper.setKodeSatker(entity.getKodeSatker().equals(null) ? null : entity.getKodeSatker());
        wrapper.setNamaBank(entity.getNamaBank().equals(null) ? null : entity.getNamaBank());
        wrapper.setNamaRek(entity.getNamaRek().equals(null) ? null : entity.getNamaRek());
        wrapper.setNoIzin(entity.getNoIzin().equals(null) ? null : entity.getNoIzin());
        wrapper.setNorek(entity.getNorek().equals(null) ? null : entity.getNorek());
        wrapper.setTglIzin(entity.getTglIzin().equals(null) ? null : entity.getTglIzin());
        wrapper.setOwner(entity.getOwner().equals(null) ? null : entity.getOwner());
        wrapper.setKodeUnitTeknis(entity.getKodeUnitTeknis().equals(null) ? null : entity.getKodeUnitTeknis());
        wrapper.setStatusRekening(entity.getStatusRekening().equals(null) ? null : entity.getStatusRekening());
        wrapper.setDescStatusRekening(entity.getDescStatusRekening().equals(null) ? null : entity.getDescStatusRekening());

        return wrapper;
    }

    private List<RekeningBendaharaWrapper> toWrapperList(List<RekeningBendahara> entityList) {
        List<RekeningBendaharaWrapper> wrapperList = new ArrayList<RekeningBendaharaWrapper>();
        for (RekeningBendahara entity : entityList) {
            RekeningBendaharaWrapper wrapper = toWrapper(entity);
            wrapperList.add(wrapper);
        }
        return wrapperList;
    }

    public PaginationList<RekeningBendaharaWrapper, RekeningBendahara> findAllWithPagination(String kodeSatker, int page, int size) {
        Pageable paging = PageRequest.of(page, size);
        Page<RekeningBendahara> rekBankPage = rekeningBendaharaRepository.findAll(kodeSatker, paging);
        List<RekeningBendahara> rekBankList = rekBankPage.getContent();
        List<RekeningBendaharaWrapper> rekBankWrapperList = toWrapperList(rekBankList);
        return new PaginationList<RekeningBendaharaWrapper, RekeningBendahara>(rekBankWrapperList, rekBankPage);
    }
}
