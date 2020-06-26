package general;

import com.google.common.hash.Hashing;
import domain.Consumidor;
import domain.Prestador;
import domain.TipoDeDocumento;
import domain.Usuario;
import org.junit.Assert;
import org.junit.Test;
import repositories.Repository;
import repositories.daos.DAOHibernate;

import java.nio.charset.StandardCharsets;
import java.time.LocalDate;

public class CuartaIteracionTest {
    private Repository<Prestador> repositorioDePrestadores = new Repository<>(new DAOHibernate(), Prestador.class);
    private Repository<Consumidor> repositorioDeConsumidores = new Repository<>(new DAOHibernate(), Consumidor.class);

    @Test
    public void joseCastilloConUsuarioEnCascadaTest(){
        Prestador joseCastillo = new Prestador("Jose", "Castillo", new Usuario("jcastillo", "qaz741wsx852"));
        joseCastillo.setTipoDeDocumento(TipoDeDocumento.DNI);
        joseCastillo.setNumeroDeIdentificacion(31777999);
        joseCastillo.setCuitCuil("21-31777999-8");
        joseCastillo.setFechaDeNacimiento(LocalDate.of(1983,8,20));
        this.repositorioDePrestadores.insert(joseCastillo);
        Integer idJose = joseCastillo.getId();

        Prestador joseCastilloRecuperado = this.repositorioDePrestadores.find(idJose);
        Assert.assertEquals(Hashing.sha256().hashString("qaz741wsx852", StandardCharsets.UTF_8).toString(), joseCastilloRecuperado.getUsuario().getContrasenia());
    }

    @Test
    public void joseCastilloConTelefonosEmailsTest(){
        Prestador joseCastillo = new Prestador("Jose", "Castillo", new Usuario("jcastillo", "qaz741wsx852"));
        joseCastillo.setTipoDeDocumento(TipoDeDocumento.DNI);
        joseCastillo.setNumeroDeIdentificacion(31777999);
        joseCastillo.setCuitCuil("21-31777999-8");
        joseCastillo.setFechaDeNacimiento(LocalDate.of(1983,8,20));

        joseCastillo.agregarMails("jcastillo@gmail.com", "jcastillo@outlook.com", "jcastillo@msn.com");
        joseCastillo.agregarTelefonos(1157889963, 20575963);

        this.repositorioDePrestadores.insert(joseCastillo);
        Integer idJose = joseCastillo.getId();

        Prestador joseCastilloRecuperado = this.repositorioDePrestadores.find(idJose);
        Assert.assertEquals(3, joseCastilloRecuperado.getEmails().size());
        Assert.assertEquals(2, joseCastilloRecuperado.getTelefonos().size());
    }
}
