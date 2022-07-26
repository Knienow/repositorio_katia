package nienow.katia.uno.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Prova;

@Dao
public interface ICRUDProvaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProva(Prova tblProva);

    @Query("SELECT * FROM tbl_prova WHERE id = :id")
    Prova getEspecificaProvaById(int id);

    List<Prova> getAllProvas();

    void updateProva(Prova tblProva);

    void deleteProva(Prova tblProva);

    void deleteProvaById(int id);

    void deleteAllProvas();
}
