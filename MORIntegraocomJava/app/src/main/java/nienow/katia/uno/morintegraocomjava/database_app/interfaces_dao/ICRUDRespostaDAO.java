package nienow.katia.uno.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;
import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Resposta;

@Dao
public interface ICRUDRespostaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertResposta(Resposta tblResposta);

    @Query("SELECT * FROM tbl_resposta WHERE id = :id")
    Resposta getEspecificaRespostaById(int id);

    List<Resposta> getAllRespostas();

    void updateResposta(Resposta tblResposta);

    void deleteResposta(Resposta tblResposta);

    void deleteRespostaById(int id);

    void deleteAllRespostas();
}




