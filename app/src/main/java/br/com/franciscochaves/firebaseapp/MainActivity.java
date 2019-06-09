package br.com.franciscochaves.firebaseapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    // Obtendo o nó raiz do database
    private DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    // Criando nó filho
    private DatabaseReference usuarioReference = databaseReference.child("usuario");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //databaseReference.child("pontos").setValue("100");
        usuarioReference.child("001").child("nome").setValue("Francisco Chaves");
        usuarioReference.child("002").child("nome").setValue("Maria Almeida");
    }
}
