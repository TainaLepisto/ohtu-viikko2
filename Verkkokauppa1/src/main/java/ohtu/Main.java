package ohtu;

import ohtu.verkkokauppa.Kauppa;
import ohtu.verkkokauppa.Kirjanpito;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {

    public static void main(String[] args) {
        
         ApplicationContext ctx = new FileSystemXmlApplicationContext("src/main/resources/spring-context.xml");
 
        Kauppa kauppa = ctx.getBean(Kauppa.class);
    
        Kirjanpito kirjanpito      = ctx.getBean(Kirjanpito.class); 
        //Varasto varasto            = new Varasto(kirjanpito);
        //Pankki pankki              = new Pankki(kirjanpito);
        //Viitegeneraattori viitegen = new Viitegeneraattori();
        //Kauppa kauppa              = new Kauppa(varasto, pankki, viitegen);

        //Kauppa kauppa = new Kauppa();
        //Kauppa kauppa = new Kauppa(varasto.getInstance(), Pankki.getInstance(), Viitegeneraattori.getInstance() );


        // kauppa hoitaa yhden asiakkaan kerrallaan seuraavaan tapaan:
        kauppa.aloitaAsiointi();
        kauppa.lisaaKoriin(1);
        kauppa.lisaaKoriin(3);
        kauppa.lisaaKoriin(3);
        kauppa.poistaKorista(1);
        kauppa.tilimaksu("Pekka Mikkola", "1234-12345");

        // seuraava asiakas
        kauppa.aloitaAsiointi();
        for (int i = 0; i < 24; i++) {
            kauppa.lisaaKoriin(5);
        }

        kauppa.tilimaksu("Arto Vihavainen", "3425-1652");

        // kirjanpito
        for (String tapahtuma : kirjanpito.getTapahtumat()) {
            System.out.println(tapahtuma);
        }
    }
}
