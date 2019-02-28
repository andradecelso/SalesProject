package br.com.javacomcafe.saleproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    private EditText txtLogin;
    private EditText txtSenha;

    private Button btnOK;
    private Button btnSair;

    private String login, senha;
    private Usuario user;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLogin = findViewById(R.id.txtLogin);
        txtSenha = findViewById(R.id.txtSenha);
        btnOK = findViewById(R.id.btnOK);
        btnSair = findViewById(R.id.btnSair);
        user = new Usuario("admin", "senha");
        Usuario.listaUsuarios.add(user);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                login = txtLogin.getText().toString();
                senha = txtSenha.getText().toString();

                Usuario loginTentativa = new Usuario(login,senha);

                if (Usuario.existUser(login,senha)){
                    Toast.makeText(MainActivity.this, "Sucesso", Toast.LENGTH_SHORT).show();

                    if(loginTentativa.getNome().equalsIgnoreCase("admin")){
                        setContentView(R.layout.activity_tela_admin);

                    } else setContentView(R.layout.activity_tela_usuario);
                }else
                {
                    Toast.makeText(MainActivity.this, "Opa", Toast.LENGTH_SHORT).show();
                }




            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MainActivity.this.finish();
            }
        });

    }




}


