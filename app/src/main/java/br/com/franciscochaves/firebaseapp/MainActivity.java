package br.com.franciscochaves.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import br.com.franciscochaves.firebaseapp.model.Produto;
import br.com.franciscochaves.firebaseapp.model.Usuario;

public class MainActivity extends AppCompatActivity {

    // Obtendo o nó raiz do database
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    // Criando nó filho
    private DatabaseReference usuarioReference = databaseReference.child("usuario");
    private DatabaseReference produtoReference = databaseReference.child("produto");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseReference.child("pontos").setValue("100");
        usuarioReference.child("001").child("nome").setValue("Francisco Chaves");
        usuarioReference.child("002").child("nome").setValue("Maria Almeida");

        Usuario usuario = new Usuario();
        usuario.setNome("Fernanda");
        usuario.setSobrenome("Freitas");
        usuario.setIdade(25);
        usuario.setSexo("Feminino");

        usuarioReference.child("003").setValue(usuario);

        Produto produto = new Produto();
        produto.setDescricao("Notebook WP40");
        produto.setCor("Branco");
        produto.setFabricante("HP");

        produtoReference.child("002").setValue(produto);


        produtoReference = databaseReference.child("produto").child("002");
        produtoReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // o método será chamado sempre que os dados forem alterados
                Log.i("FIREBASE", dataSnapshot.getValue().toString());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                // Se houver erro ao recuperar os dados no banco de dados
            }
        });

    }
}
