package br.com.zupacademy.robson.transacao.establishment;

public class EstablishmentResponse {

    private String name;
    private String city;
    private String address;

    public EstablishmentResponse(Establishment estabelecimento) {
        this.name = estabelecimento.getName();
        this.city = estabelecimento.getCity();
        this.address = estabelecimento.getAddress();
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

}
