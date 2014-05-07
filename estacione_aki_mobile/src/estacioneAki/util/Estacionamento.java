package estacioneAki.util;

import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root(name="estacionamento")
public class Estacionamento {
	@Element
    private String nome;
	
	@Element
    private String endereco;
	
	@Element
    private String cnpj;
	
	@Element
    private String latitude;
	
	@Element
    private String longitude;
	
	@Element
    public String numeroDeVagas;
	
	@Element
    private String precoHora; 
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getEndereco() {
		return endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	
	public String getLatitude() {
		return latitude;
	}
	
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	public String getLongitude() {
		return longitude;
	}
	
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	public String getNumeroDeVagas() {
		return numeroDeVagas;
	}
	
	public void setNumeroDeVagas(String numeroDeVagas) {
		this.numeroDeVagas = numeroDeVagas;
	}
	
	public String getPrecoHora() {
		return precoHora;
	}
	
	public void setPrecoHora(String precoHora) {
		this.precoHora = precoHora;
	}
	
	public boolean temVagas(){
		if(new Integer(numeroDeVagas) >= 1){
			return true;
		}else{
			return false;
		}
	}
}
