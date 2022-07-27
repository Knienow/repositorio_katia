package nienow.katia.uno.morintegraocomjava.database_app.dbcallbacks;

import java.util.List;

import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Aluno;

public interface IAlunoDbCallback {
    void getAlunoFromDB(List<Aluno> tblAluno);
}
