package nienow.katia.uno.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Pergunta;

@Dao
public interface ICRUDPerguntaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPergunta(Pergunta tblPergunta);

    @Query("SELECT * FROM tbl_pergunta WHERE id = :id")
    Pergunta getEspecificaPerguntaById(int id);

    List<Pergunta> getAllPerguntas();

    void updatePergunta(Pergunta tblPergunta);

    void deletePergunta(Pergunta tblPergunta);

    void deletePerguntaById(int id);

    void deleteAllPerguntas();
}



