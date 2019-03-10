package com.example.barajanumero;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class VolleySigleton {

    private static VolleySigleton InstanceSigleton=null;
    private RequestQueue requestQueue;

    private VolleySigleton(Context context) {
        requestQueue = Volley.newRequestQueue(context);
    }

    public static VolleySigleton getInstanceSigleton(Context context) {
        if (InstanceSigleton== null)
        {
            InstanceSigleton = new VolleySigleton(context);
        }

        return InstanceSigleton;
    }


    public RequestQueue getRequestQueue() {
        return requestQueue;
    }
}
