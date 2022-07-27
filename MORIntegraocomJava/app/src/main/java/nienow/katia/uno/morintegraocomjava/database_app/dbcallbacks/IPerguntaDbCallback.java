package nienow.katia.uno.morintegraocomjava.database_app.dbcallbacks;

import java.util.List;

import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Pergunta;

public interface IPerguntaDbCallback {
    void getPerguntaFromDB(List<Pergunta> tblPergunta);
}