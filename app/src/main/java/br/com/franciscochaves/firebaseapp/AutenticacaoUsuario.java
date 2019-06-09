package br.com.franciscochaves.firebaseapp;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class AutenticacaoUsuario extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_autenticacao_usuario);

        firebaseAuth = FirebaseAuth.getInstance();

        //Login do usuário
        firebaseAuth.signInWithEmailAndPassword("francisco@franciscochaves.com.br", "francisco1234")
                .addOnCompleteListener(AutenticacaoUsuario.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {//Sucesso ao cadastrar
                            Log.i("signIn", "Sucesso ao fazer login usuário!!!!");
                        } else {//Erro ao cadastrar
                            Log.i("signIn", "Erro ao fazer login usuário!!!!");
                        }
                        
                    }
                });

        //Cadastro
        /*firebaseAuth.createUserWithEmailAndPassword("francisco@franciscochaves.com.br", "francisco1234")
                .addOnCompleteListener(AutenticacaoUsuario.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {//Sucesso ao cadastrar
                            Log.i("createUser", "Sucesso ao cadastrar usuário!!!!");
                        } else {//Erro ao cadastrar
                            Log.i("createUser", "Erro ao cadastrar usuário!!!!");
                        }

                    }
                });*/

    }
}
