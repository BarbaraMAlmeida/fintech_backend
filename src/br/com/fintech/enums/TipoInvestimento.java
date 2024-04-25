package br.com.fintech.enums;

public enum TipoInvestimento {
	TESOURODIRETOSELIC(1),
	CDBS(3);

	
	private int cd_tipo_investimento;
	TipoInvestimento(int cd_tipo_investimento) {
        this.cd_tipo_investimento = cd_tipo_investimento;
	}
	
   public int getCdTipoInvestimento() {
        return this.cd_tipo_investimento;
    }

}
