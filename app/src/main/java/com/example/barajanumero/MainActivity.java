package com.example.barajanumero;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    Button mostrar,enviar;
    String URLnumero = "http://nuevo.rnrsiilge-org.mx/baraja/numero";
    String URLenviar ="http://nuevo.rnrsiilge-org.mx/baraja/enviar";
    TextView texto;
    Integer num;
    int suma;
    int numero;
    ImageView imagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        findViewById(R.id.mostrar).setOnClickListener(this);
        findViewById(R.id.enviar).setOnClickListener(this);
        texto=findViewById(R.id.texto);
        imagen=findViewById(R.id.imagen);

    }

    @Override
    public void onClick(View v) {
        switch(v.getId())
        {
            case R.id.mostrar:

                JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(
                        Request.Method.GET,
                        URLnumero,
                        null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    numero = response.getInt("numero");

                                    suma = suma + numero;
//                                    Toast.makeText(MainActivity.this,response.getString("numero"),Toast.LENGTH_SHORT).show();
                                    texto.setText(String.valueOf(suma));

                                    switch (numero) {
                                        case 1:
                                            imagen.setImageResource(R.drawable.a);
                                            break;
                                        case 2:
                                            imagen.setImageResource(R.drawable.dos);
                                            break;
                                        case 3:
                                            imagen.setImageResource(R.drawable.tres);
                                            break;
                                        case 4:
                                            imagen.setImageResource(R.drawable.cuatro);
                                            break;
                                        case 5:
                                            imagen.setImageResource(R.drawable.cinco);
                                            break;
                                        case 6:
                                            imagen.setImageResource(R.drawable.seis);
                                            break;
                                        case 7:
                                            imagen.setImageResource(R.drawable.siete);
                                            break;
                                        case 8:
                                            imagen.setImageResource(R.drawable.ocho);
                                            break;
                                        case 9:
                                            imagen.setImageResource(R.drawable.nueve);
                                            break;
                                        case 10:
                                            imagen.setImageResource(R.drawable.diez);
                                            break;
                                        case 11:
                                            imagen.setImageResource(R.drawable.once);
                                            break;
                                        case 12:
                                            imagen.setImageResource(R.drawable.doce);
                                            break;
                                        case 13:
                                            imagen.setImageResource(R.drawable.trece);
                                            break;
                                    }

                                    if(suma > 21)
                                    {
                                        Toast.makeText(getApplicationContext(),"Perdiste pinche pendejo",Toast.LENGTH_SHORT).show();

                                    }


                                }
                                catch (JSONException e) {
                                    e.printStackTrace();
                                }
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        });
                VolleySigleton.getInstanceSigleton(getApplicationContext()).getRequestQueue().add(jsonObjectRequest);

                break;
            case R.id.enviar:
                JSONObject jo = new JSONObject();
                try {
                    jo.put("nombre","Gera");
                    jo.put("numero",suma);
                } catch (JSONException e) {
                    e.printStackTrace();
                }


                JsonObjectRequest json = new JsonObjectRequest(Request.Method.POST,
                        URLenviar,
                        jo,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Toast.makeText(getApplicationContext(),"Enviado",Toast.LENGTH_SHORT).show();
                            }
                        },
                        new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {


                            }
                        });
                VolleySigleton.getInstanceSigleton(getApplicationContext()).getRequestQueue().add(json);
                break;

        }

    }
}
