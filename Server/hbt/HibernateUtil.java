package hbt;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import entities.AlmacenamientoEntity;
import entities.ClienteEntity;
import entities.CuentaCorrienteEntity;
import entities.EmpleadoEntity;
import entities.EtapaProductivaEntity;
import entities.FacturaEntity;
import entities.ItemOCMPEntity;
import entities.ItemsPedidoEntity;
import entities.ItemsPedidoIDEntity;
import entities.LoteEntity;
import entities.MaterialEntity;
import entities.MaterialPorPrendaEntity;
import entities.NotaDeCredito;
import entities.OrdenCMPEntity;
import entities.OrdenDeProduccionEntity;
import entities.PedidoEntity;
import entities.PrendaEntity;
import entities.PrendaVentaEntity;
import entities.RemitoEntity;
import entities.StockEntity;
import entities.SucursalEntity;

public class HibernateUtil
{
    private static final SessionFactory sessionFactory;
    static
    {
        try
        {
        	 AnnotationConfiguration config = new AnnotationConfiguration();
        	 config.addAnnotatedClass(SucursalEntity.class);
        	 config.addAnnotatedClass(EmpleadoEntity.class);
        	 config.addAnnotatedClass(ClienteEntity.class);
        	 config.addAnnotatedClass(CuentaCorrienteEntity.class);
        	 config.addAnnotatedClass(PedidoEntity.class);
        	 config.addAnnotatedClass(ItemsPedidoIDEntity.class);
        	 config.addAnnotatedClass(ItemsPedidoEntity.class);
        	 config.addAnnotatedClass(PrendaEntity.class);
        	 config.addAnnotatedClass(NotaDeCredito.class);
        	 config.addAnnotatedClass(MaterialPorPrendaEntity.class);
        	 config.addAnnotatedClass(MaterialEntity.class);
        	 config.addAnnotatedClass(ItemOCMPEntity.class);
        	 config.addAnnotatedClass(OrdenCMPEntity.class);
        	 config.addAnnotatedClass(OrdenDeProduccionEntity.class);
        	 config.addAnnotatedClass(LoteEntity.class);
        	 config.addAnnotatedClass(AlmacenamientoEntity.class);
        	 config.addAnnotatedClass(FacturaEntity.class);
        	 config.addAnnotatedClass(RemitoEntity.class);
        	 config.addAnnotatedClass(PrendaVentaEntity.class);
        	 config.addAnnotatedClass(StockEntity.class);
        	 config.addAnnotatedClass(EtapaProductivaEntity.class);
             sessionFactory = config.buildSessionFactory();
        }
        catch (Throwable ex)
        {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }
  
    public static SessionFactory getSessionFactory()
    {
        return sessionFactory;
    }
}
