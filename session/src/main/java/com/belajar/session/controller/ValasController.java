package com.belajar.session.controller;

import com.belajar.session.entity.valas.RekeningBendahara;
import com.belajar.session.entity.valas.Spp;
import com.belajar.session.request.valas.GetRekBankRequest;
import com.belajar.session.request.valas.GetSppRequest;
import com.belajar.session.response.CommonResponse;
import com.belajar.session.service.ValasService;
import com.belajar.session.util.DataResponsePagination;
import com.belajar.session.wrapper.RekeningBendaharaWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ValasController {
    @Autowired
    ValasService valasService;

    private static final Logger LOGGER = LoggerFactory.getLogger(SessionController.class);

    @RequestMapping(value = {"/getSpp"}, method = RequestMethod.POST, consumes = "application/json")
    public CommonResponse getSpp(@RequestBody GetSppRequest request){
        LOGGER.info("req" + request);
        LOGGER.info("req: " + request.getKodeSatker() + ", " + request.getKategoriKas());
        List<Spp> hasil = valasService.getSpp(request.getKategoriKas(), request.getKodeSatker());
        LOGGER.info("hasil" + hasil);
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(hasil);
        return response;
    }

    @RequestMapping(value = {"/getRekBank"}, method = RequestMethod.POST, consumes = "application/json")
    public CommonResponse getRekBank(@RequestBody GetRekBankRequest request){
        LOGGER.info("req" + request);
        LOGGER.info("req: " + request.getKodeSatker());
        List<RekeningBendahara> hasil = valasService.getRekBank(request.getKodeSatker());
        LOGGER.info("hasil" + hasil);
        CommonResponse response = new CommonResponse();
        response.setStatus(true);
        response.setObject(hasil);
        return response;
    }

    @RequestMapping(value = {"/getRekBankPaginated"}, method = RequestMethod.POST, consumes = "application/json")
    public DataResponsePagination<RekeningBendaharaWrapper, RekeningBendahara> findAllWithPagination(@RequestParam("kodeSatker") String kodeSatker,
                                                                                                     @RequestParam("page") int page,
                                                                                                     @RequestParam("size") int size) {
        return new DataResponsePagination<RekeningBendaharaWrapper, RekeningBendahara>(
                valasService.findAllWithPagination(kodeSatker, page, size));
    }
}
