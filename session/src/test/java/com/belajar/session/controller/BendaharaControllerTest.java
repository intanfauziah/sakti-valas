package com.belajar.session.controller;

import com.belajar.session.entity.bendahara.KasBankBenPeng;
import com.belajar.session.request.bendahara.NoSp2dExcludeRequest;
import com.belajar.session.request.bendahara.TotalSaldoKasBankXtahunRequest;
import com.belajar.session.service.BendaharaService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BendaharaController.class)
public class BendaharaControllerTest {
    @MockBean
    private BendaharaService bendaharaService;

    private BendaharaController bendaharaController;

    @Autowired
    private MockMvc mockMvc;

    ObjectMapper mapper = new ObjectMapper();

//    @Test
//    public void totalSaldoKasBankXtahun(){
//        TotalSaldoKasBankXtahunRequest request = new TotalSaldoKasBankXtahunRequest();
//        CommonResponse response = bendaharaController.totalSaldoKasBankXtahun(request);
//
//        assertNotNull(response);
//        assertTrue(response.isStatus());
//    }

    @Test
    public void totalSaldoKasBankXTahun() throws Exception{
        TotalSaldoKasBankXtahunRequest request = new TotalSaldoKasBankXtahunRequest();
        request.setKodeSatker("017312");
        request.setKodeTahunAnggaran("2022");
        request.setKodeUnitTeknis("43917100");

        KasBankBenPeng kasBankBenPeng = new KasBankBenPeng();
        kasBankBenPeng.setKodeSatker(request.getKodeSatker());

        BigDecimal hasil = new BigDecimal(0);

        when(bendaharaService.totalSaldoKasBankXtahun(request.getKodeSatker(),request.getKodeTahunAnggaran(), request.getKodeUnitTeknis()))
                .thenReturn(hasil);

        mockMvc.perform(post("/totalSaldoKasBankXtahun")
                        .content(mapper.writeValueAsString(request))
                        .contentType(MediaType.APPLICATION_JSON))
                        .andExpect(status().isOk());
    }

    @Test
    public void noSp2dExclude() throws Exception {
        NoSp2dExcludeRequest request = new NoSp2dExcludeRequest();
        request.setKodeSatker("017312");
        request.setKodeTahunAnggaran("2022");

        List<String> sp2dExclude = new ArrayList<String>();

        when(bendaharaService.noSp2dExclude(request.getKodeSatker(), request.getKodeTahunAnggaran()))
                .thenReturn(sp2dExclude);

        mockMvc.perform(post("/noSp2dExclude")
                .content(mapper.writeValueAsString(request))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
