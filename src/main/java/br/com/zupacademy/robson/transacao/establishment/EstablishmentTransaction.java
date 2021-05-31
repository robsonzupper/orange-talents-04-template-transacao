package br.com.zupacademy.robson.transacao.establishment;

public class EstablishmentTransaction {

    private String name;
    private String city;
    private String address;

    public EstablishmentTransaction(String name, String city, String address) {
        this.name = name;
        this.city = city;
        this.address = address;
    }

    public EstablishmentTransaction() {
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

    @Override
    public String toString() {
        return "EstablishmentTransacao{"
                + "nome='" + name + '\''
                + ", cidade='" + city + '\''
                + ", endereco='" + address + '\''
                + '}';
    }

    public Establishment converte() {
        return new Establishment(name, city, address);
    }
}
