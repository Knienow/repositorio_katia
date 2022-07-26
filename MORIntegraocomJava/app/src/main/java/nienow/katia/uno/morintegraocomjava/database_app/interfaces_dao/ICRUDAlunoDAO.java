package nienow.katia.uno.morintegraocomjava.database_app.interfaces_dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Transaction;
import androidx.room.Update;

import java.util.List;

import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Aluno;

@Dao
public interface ICRUDAlunoDAO {

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAluno(Aluno tblAluno);

    @Query("SELECT * FROM tbl_aluno WHERE id = :id")
    Aluno getEspecificaAlunoById(int id);

    @Query("SELECT * FROM tbl_aluno ORDER BY id DESC")

    List<Aluno> getAllAlunos();

    @Transaction
    @Update(entity = Aluno.class)

    void updateAluno(Aluno tblAluno);

    void deleteAluno(Aluno tblAluno);

    void deleteAlunoById(int id);

    void deleteAllAlunos();
}