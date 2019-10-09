package com.hst.customer.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.makeramen.roundedimageview.RoundedTransformationBuilder;
import com.hst.customer.R;
import com.hst.customer.bean.support.CartService;
import com.hst.customer.bean.support.Service;
import com.hst.customer.helper.ProgressDialogHelper;
import com.hst.customer.servicehelpers.ServiceHelper;
import com.hst.customer.serviceinterfaces.IServiceListener;
import com.hst.customer.utils.PreferenceStorage;
import com.hst.customer.utils.SkilExConstants;
import com.hst.customer.utils.SkilExValidator;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Transformation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainServiceAdapterTemp extends RecyclerView.Adapter<MainServiceAdapterTemp.ViewHolder> implements IServiceListener {

    private ArrayList<Service> categoryArrayList;
    private Context context;
    private MainServiceAdapterTemp.OnItemClickListener onItemClickListener;
    private View.OnClickListener onClickListener;
    private final Transformation transformation;
    private ServiceHelper serviceHelper;
    private ProgressDialogHelper progressDialogHelper;


    @Override
    public void onResponse(JSONObject response) {
        try {
            String status = response.getString("status");
            if (status.equalsIgnoreCase("success")) {
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onError(String error) {

    }

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        // each data item is just a string in this case
        public ImageView mImageView, Selecttick;
        public CheckBox checkTick;
        public TextView mPrefTextView;
        public RelativeLayout rlPref;
        public RelativeLayout slPref;

        public ViewHolder(View v, int viewType) {
            super(v);
            mImageView = (ImageView) v.findViewById(R.id.sub_category_image);
            mPrefTextView = (TextView) v.findViewById(R.id.sub_category_name);
            Selecttick = (ImageView) v.findViewById(R.id.add_to_list);
            Selecttick.setVisibility(View.GONE);
            Selecttick.setOnClickListener(this);

//            if (viewType == 1) {
//                rlPref = (RelativeLayout) v.findViewById(R.id.rlPref);
//            } else {
//                rlPref = (RelativeLayout) v;
//            }
//
//            rlPref.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClick(v, getAdapterPosition());
            }
//            else {
//                onClickListener.onClick(Selecttick);
//            }
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public MainServiceAdapterTemp(Context context, ArrayList<Service> categoryArrayList, MainServiceAdapterTemp.OnItemClickListener onItemClickListener) {
        this.categoryArrayList = categoryArrayList;
        this.context = context;
        this.onItemClickListener = onItemClickListener;

        transformation = new RoundedTransformationBuilder()
                .cornerRadiusDp(5)
                .oval(false)
                .build();
    }

    // Create new views (invoked by the layout manager)
    @Override
    public MainServiceAdapterTemp.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                int viewType) {
        // create a new view
        View parentView;
        //Log.d("CategoryAdapter","viewType is"+ viewType);
        //if (viewType == 1) {
        parentView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.category_list_item, parent, false);

//        }
//        else {
//            parentView = LayoutInflater.from(parent.getContext())
//                    .inflate(R.layout.preference_view_type2, parent, false);
//        }
        // set the view's size, margins, paddings and layout parameters
        MainServiceAdapterTemp.ViewHolder vh = new MainServiceAdapterTemp.ViewHolder(parentView, viewType);
        serviceHelper = new ServiceHelper(context);
        serviceHelper.setServiceListener(this);
        progressDialogHelper = new ProgressDialogHelper(context);
        return vh;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(MainServiceAdapterTemp.ViewHolder holder, final int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        if (PreferenceStorage.getLang(context).equalsIgnoreCase("tamil")) {
            holder.mPrefTextView.setText(categoryArrayList.get(position).getservice_ta_name());
        } else {
            holder.mPrefTextView.setText(categoryArrayList.get(position).getservice_name());
        }

        //imageLoader.displayImage(events.get(position).getEventLogo(), holder.imageView, AppController.getInstance().getLogoDisplayOptions());
        if (SkilExValidator.checkNullString(categoryArrayList.get(position).getSelected())) {
            Picasso.get().load(categoryArrayList.get(position).getservice_pic_url()).into(holder.mImageView);
        } else {
            holder.mImageView.setImageResource(R.drawable.ic_user_profile_image);
        }

        if (categoryArrayList.get(position).getSelected().equalsIgnoreCase("0")) {
            holder.Selecttick.setBackgroundColor(ContextCompat.getColor(context, R.color.green));
            holder.Selecttick.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_completed));
        } else {
            holder.Selecttick.setBackgroundColor(ContextCompat.getColor(context, R.color.colorPrimary));
            holder.Selecttick.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.ic_control_point_black_24dp));
        }

        holder.Selecttick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (categoryArrayList.get(position).getSelected().equalsIgnoreCase("0")) {
                    categoryArrayList.get(position).setSelected("1");
                    addService(position);
                } else {
                    categoryArrayList.get(position).setSelected("0");
                    removeService(position);
                }
                notifyDataSetChanged();
            }
        });


    }


    @Override
    public int getItemCount() {
        return categoryArrayList.size();

    }

    public Service getItem(int position) {
        return categoryArrayList.get(position);
    }


    @Override
    public int getItemViewType(int position) {
        /*if ((position + 1) % 7 == 4 || (position + 1) % 7 == 0) {
            return 2;
        } else {
            return 1;
        }*/
        if (categoryArrayList.get(position) != null || categoryArrayList.get(position).getSize() > 0)
            return categoryArrayList.get(position).getSize();
        else
            return 1;
    }

    public interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

//    public void deleteItem(int position) {
//        mRecentlyDeletedItem = categoryArrayList.get(position);
//        mRecentlyDeletedItemPosition = position;
//        removeService(position);
//
//    }

    private void removeService(int position) {

        JSONObject jsonObject = new JSONObject();
        String idService = "";
        idService = categoryArrayList.get(position).getservice_id();
        try {
            jsonObject.put(SkilExConstants.CART_ID, idService);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
        String url = SkilExConstants.BUILD_URL + SkilExConstants.REMOVE_FROM_CART;
        serviceHelper.makeGetServiceCall(jsonObject.toString(), url);
    }

    private void addService(int position) {

        JSONObject jsonObject = new JSONObject();
        String idService = "";
        idService = categoryArrayList.get(position).getservice_id();
        try {
            jsonObject.put(SkilExConstants.CART_ID, idService);
        } catch (JSONException e) {
            e.printStackTrace();
        }

//        progressDialogHelper.showProgressDialog(getString(R.string.progress_loading));
        String url = SkilExConstants.BUILD_URL + SkilExConstants.ADD_TO_CART;
        serviceHelper.makeGetServiceCall(jsonObject.toString(), url);
    }

}
