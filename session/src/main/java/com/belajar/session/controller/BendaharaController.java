package com.belajar.session.controller;

import com.belajar.session.request.bendahara.NoSp2dExcludeRequest;
import com.belajar.session.request.bendahara.TotalSaldoKasBankXtahunRequest;
import com.belajar.session.response.CommonResponse;
import com.belajar.session.service.BendaharaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;

@RestController
public class BendaharaController {
    @Autowired
    private BendaharaService bendaharaService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(value = {"/totalSaldoKasBankXtahun"}, method = RequestMethod.POST, consumes = "application/json")
    public CommonResponse totalSaldoKasBankXtahun(@RequestBody TotalSaldoKasBankXtahunRequest request){
        LOGGER.info("req" + request);
        LOGGER.info("req: " + request.getKodeSatker() + ", " + request.getKodeTahunAnggaran() + ", " + request.getKodeUnitTeknis());
        BigDecimal totalSaldo = bendaharaService.totalSaldoKasBankXtahun(request.getKodeSatker(), request.getKodeTahunAnggaran(), request.getKodeUnitTeknis());
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(totalSaldo);
        return response;
    }

    @RequestMapping(value = {"/noSp2dExclude"}, method = RequestMethod.POST, consumes = "application/json")
    public CommonResponse noSp2dExclude(@RequestBody NoSp2dExcludeRequest request){
        LOGGER.info("req" + request);
        LOGGER.info("req: " + request.getKodeSatker() + ", " + request.getKodeTahunAnggaran());
        List<String> hasil = bendaharaService.noSp2dExclude(request.getKodeSatker(), request.getKodeTahunAnggaran());
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(hasil);
        return response;
    }

}
