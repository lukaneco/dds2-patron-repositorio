package general;

import domain.Consumidor;
import domain.Prestador;
import org.junit.Assert;
import org.junit.Test;
import repositories.Repository;
import repositories.daos.DAOHibernate;

public class TerceraIteracionTest {
    private Repository<Prestador> repositorioDePrestadores = new Repository<>(new DAOHibernate(), Prestador.class);
    private Repository<Consumidor> repositorioDeConsumidores = new Repository<>(new DAOHibernate(), Consumidor.class);

    @Test
    public void juanRodriguezTest(){
        Prestador juanRodriguez = new Prestador("Juan", "Rodriguez");
        this.repositorioDePrestadores.insert(juanRodriguez);
        Integer idJuanRodriguez = juanRodriguez.getId();
        juanRodriguez = null;
        Prestador supuestoJuanRodriguez = this.repositorioDePrestadores.find(idJuanRodriguez);
        Assert.assertEquals("Juan", supuestoJuanRodriguez.getNombre());
    }

    @Test
    public void modificoAMelisaSinImpactoEnBaseTest(){
        Consumidor melisaVolpe = new Consumidor("Melisa", "Volpe");
        this.repositorioDeConsumidores.insert(melisaVolpe);
        melisaVolpe.setNombre("Melisa Jesica");
        melisaVolpe.setApellido("Contreras");

        Integer idMelisa = melisaVolpe.getId();

        Consumidor supuestaMelisa = this.repositorioDeConsumidores.find(idMelisa);
        Assert.assertFalse(melisaVolpe.equals(supuestaMelisa));
        Assert.assertEquals("Melisa", supuestaMelisa.getNombre());
    }

    @Test
    public void modificoAMelisaImpactandoEnBaseTest(){
        Consumidor melisaVolpe = new Consumidor("Melisa", "Volpe");
        this.repositorioDeConsumidores.insert(melisaVolpe);
        melisaVolpe.setNombre("Melisa Jesica");
        melisaVolpe.setApellido("Contreras");

        this.repositorioDeConsumidores.update(melisaVolpe);

        Integer idMelisa = melisaVolpe.getId();

        Consumidor supuestaMelisa = this.repositorioDeConsumidores.find(idMelisa);
        Assert.assertEquals("Melisa Jesica", supuestaMelisa.getNombre());
    }
}
