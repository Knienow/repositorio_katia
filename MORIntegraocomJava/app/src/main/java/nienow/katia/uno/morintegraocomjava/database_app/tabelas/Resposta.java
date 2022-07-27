package nienow.katia.uno.morintegraocomjava.database_app.tabelas;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "tbl_resposta"
        , indices = {@Index(value = "id")}
        , foreignKeys = {@ForeignKey(entity = Pergunta.class, parentColumns = "id",
        childColumns = "id", onUpdate = CASCADE, onDelete = CASCADE)})
public class Resposta {
    @PrimaryKey
    private int id;

    private String resposta;

    public Resposta() {}

    //Construtor de cópia
    public Resposta(Resposta tblResposta){
        this.id       = tblResposta.getId();
        this.resposta = tblResposta.getResposta();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResposta() {
        return resposta;
    }

    public void setResposta(String resposta) {
        this.resposta = resposta;
    }
}