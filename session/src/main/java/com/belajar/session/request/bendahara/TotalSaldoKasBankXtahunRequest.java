package com.belajar.session.request.bendahara;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TotalSaldoKasBankXtahunRequest {
    private String kodeSatker;
    private String kodeTahunAnggaran;
    private String kodeUnitTeknis;
}
