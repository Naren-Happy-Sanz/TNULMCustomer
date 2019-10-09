package com.hst.customer.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.hst.customer.R;
import com.hst.customer.bean.support.OngoingService;
import com.hst.customer.helper.AlertDialogHelper;
import com.hst.customer.helper.ProgressDialogHelper;
import com.hst.customer.interfaces.DialogClickListener;
import com.hst.customer.servicehelpers.ServiceHelper;
import com.hst.customer.serviceinterfaces.IServiceListener;
import com.hst.customer.utils.CommonUtils;
import com.hst.customer.utils.PreferenceStorage;
import com.hst.customer.utils.SkilExConstants;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import static android.util.Log.d;

public class OngoingServiceDetailActivity extends AppCompatActivity implements IServiceListener, DialogClickListener, View.OnClickListener {

    private static final String TAG = OngoingServiceDetailActivity.class.getName();
    private ServiceHelper serviceHelper;
    private ProgressDialogHelper progressDialogHelper;
    OngoingService ongoingService;
    private TextView catName, subCatName, custName, servicedate, orderID, serviceProvider, servicePerson, servicePersonPhone,
            serviceStartTime, estimatedCost;
    Button track;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ongoing_services_detail);

        serviceHelper = new ServiceHelper(this);
        serviceHelper.setServiceListener(this);
        progressDialogHelper = new ProgressDialogHelper(this);

        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        ongoingService = (OngoingService) getIntent().getSerializableExtra("serviceObj");

        callGetSubCategoryServiceDetails();

        initiateAll();

    }

    public void callGetSubCategoryServiceDetails() {
        if (CommonUtils.isNetworkAvailable(this)) {
            progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
            loadOnGoService();
        } else {
            AlertDialogHelper.showSimpleAlertDialog(this, "No Network connection");
        }
    }

    private void loadOnGoService() {
        JSONObject jsonObject = new JSONObject();
        String id = "";
        id = ongoingService.getservice_order_id();
        try {
            jsonObject.put(SkilExConstants.SERVICE_ORDER_ID, id);

        } catch (JSONException e) {
            e.printStackTrace();
        }

//        progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
        String url = SkilExConstants.BUILD_URL + SkilExConstants.ONGOING_SERVICE_DETAILS;
        serviceHelper.makeGetServiceCall(jsonObject.toString(), url);
    }

    @Override
    public void onAlertPositiveClicked(int tag) {

    }

    @Override
    public void onAlertNegativeClicked(int tag) {

    }

    private void initiateAll() {
        findViewById(R.id.back_btn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        catName = (TextView) findViewById(R.id.category_name);
        subCatName = (TextView) findViewById(R.id.sub_category_name);
        custName = (TextView) findViewById(R.id.customer_name);
        servicedate = (TextView) findViewById(R.id.service_date);
        orderID = (TextView) findViewById(R.id.order_id);
        serviceProvider = (TextView) findViewById(R.id.service_provider_name_text);
        servicePerson = (TextView) findViewById(R.id.service_person_name);
//        servicePersonPhone = (TextView) findViewById(R.id.service_person_experience);
        servicePersonPhone = (TextView) findViewById(R.id.service_person_number);
        serviceStartTime = (TextView) findViewById(R.id.service_statring_time_text);
        estimatedCost = (TextView) findViewById(R.id.service_estimate_text);
        track = (Button) findViewById(R.id.track);
        track.setOnClickListener(this);
    }

    private boolean validateResponse(JSONObject response) {
        boolean signInSuccess = false;
        if ((response != null)) {
            try {
                String status = response.getString("status");
                String msg = response.getString(SkilExConstants.PARAM_MESSAGE);
                String msg_en = response.getString(SkilExConstants.PARAM_MESSAGE_ENG);
                String msg_ta = response.getString(SkilExConstants.PARAM_MESSAGE_TAMIL);
                d(TAG, "status val" + status + "msg" + msg);

                if ((status != null)) {
                    if (((status.equalsIgnoreCase("activationError")) || (status.equalsIgnoreCase("alreadyRegistered")) ||
                            (status.equalsIgnoreCase("notRegistered")) || (status.equalsIgnoreCase("error")))) {
                        signInSuccess = false;
                        d(TAG, "Show error dialog");

                        if (PreferenceStorage.getLang(this).equalsIgnoreCase("tamil")) {
                            AlertDialogHelper.showSimpleAlertDialog(this, msg_ta);
                        } else {
                            AlertDialogHelper.showSimpleAlertDialog(this, msg_en);
                        }

                    } else {
                        signInSuccess = true;
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return signInSuccess;
    }


    @Override
    public void onResponse(JSONObject response) {
        progressDialogHelper.hideProgressDialog();
        if (validateResponse(response)) {
            try {
//                "service_order_id": "45",
//    "main_category": "Appliance Repair",
//    "main_category_ta": "வீடு பழுது பார்த்தல்",
//    "sub_category": "AC Service and Repair",
//    "sub_category_ta": "AC சேவை மற்றும் பழுதுபார்க்கும்",
//    "service_name": "Insurance 3",
//    "service_ta_name": "Insurance 3",
//    "contact_person_name": "bala",
//    "contact_person_number": "9500923685",
//    "service_address": "Neelikonam Palayam, Coimbatore, India, ",
//    "order_date": "2019-07-26",
//    "time_slot": "20:00:00-21:00:00",
//    "provider_name": "Victor",
//    "person_name": "Ganesh",
//    "person_id": "24",
//    "person_number": "1565643456",
//    "pic": "",
//    "estimated_cost": 200,
//    "order_status": "Initiated"
                JSONObject getData = response.getJSONObject("service_list");
                if (PreferenceStorage.getLang(this).equalsIgnoreCase("tam")) {
                    catName.setText(getData.getString("main_category_ta"));
                    subCatName.setText(getData.getString("service_ta_name"));

                } else {
                    catName.setText(getData.getString("main_category"));
                    subCatName.setText(getData.getString("service_name"));

                }
                custName.setText(getData.getString("contact_person_name"));
                servicedate.setText(getData.getString("order_date"));
                orderID.setText(getData.getString("service_order_id"));
                serviceProvider.setText(getData.getString("provider_name"));
                servicePerson.setText(getData.getString("person_name"));
                servicePersonPhone.setText(getData.getString("person_number"));
                serviceStartTime.setText(getData.getString("time_slot"));
                estimatedCost.setText("₹"+getData.getInt("estimated_cost"));
                PreferenceStorage.savePersonId(this, getData.getString("person_id"));


            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onError(String error) {

    }

    @Override
    public void onClick(View v) {
        if (v == track) {
            Intent i = new Intent(getApplicationContext(), ServicePersonTrackingActivity.class);
            i.putExtra("serviceObj", ongoingService);
            startActivity(i);
            finish();
        }
    }
}
