package nienow.katia.uno.morintegraocomjava.database_app.dbcallbacks;

import java.util.List;

import nienow.katia.uno.morintegraocomjava.database_app.tabelas.Prova;

public interface IProvaDbCallback {
    void getProvaFromDB(List<Prova> tblProva);
}