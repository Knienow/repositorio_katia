package nienow.katia.uno.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;

import java.util.List;

import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Aluno;
import nienow.katia.uno.morintegraocomjava.database_app.tabelas.AlunoProva;

@Dao
public interface ICRUDAlunoProvaDAO {
    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAlunoProva(AlunoProva tblAlunoProva);

        @Query("SELECT * FROM tbl_aluno_prova WHERE aluno_id = :id")
        AlunoProva getEspecificaAlunoProvaById(int id);

        List<AlunoProva> getAllAlunosProva();

        void updateAlunoProva(Aluno tblAlunoProva);

        void deleteAlunoProva(Aluno tblAlunoProva);

        void deleteAlunoProvaById(int id);

        void deleteAllAlunosProva();
}
