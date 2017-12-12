package com.example.android.baseline.comm;


import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * Created by Palo12 on 04-05-2017.
 */

public class ObjectCaster {
    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");

    public static <T> T jSONcast(Class<T> clazz, String jsonInString) {
        //JSON from String to Object
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.readValue(jsonInString, clazz);
        } catch (IOException ex) {
            return null;
        }
    }

    public static <T> T jSONcast(Class<T> clazz, File jsonInFile) throws IOException {
        //JSON from file to Object
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonInFile, clazz);
    }

    public static <T> T jSONcast(Class<T> clazz, URL jsonInURL) throws IOException {
        //JSON from URL to Object
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonInURL, clazz);
    }
    public static <T> T cast(Class<T> clazz, Object object) {
        try {
            T castedObject = null;
            if (object == null) {
                return null;
            }
            if (clazz.isInstance(object)) {
                castedObject = clazz.cast(object);
            } else {
                String val = String.valueOf(object);
                castedObject = newInstance(clazz, val);
            }
            return castedObject;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
            return null;
        }
    }
    private static <T> T newInstance(Class<T> clazz, String val) {
        if (clazz.isAssignableFrom(BigDecimal.class)) {
            return (T) new BigDecimal(val);
        } else if (clazz.isAssignableFrom(Integer.class)) {
            return (T) new Integer(val);
        } else if (clazz.isAssignableFrom(Date.class)) {
            try {
                return (T) new Date(val);
            } catch (Exception ex) {
                return (T) parseDate(val);
            }
        }
        return (T) val;
    }

    public static Date parseDate(String date) {
        if (date == null) {
            return new Date();
        }
        try {
            return format.parse(date);
        } catch (ParseException ex) {
            return null;
        }
    }
//    public static Order getOrder(CartPOJO cart) {
//        PromoCode promoCode = cart.getPromoCode();
//        List<DishPOJO> dishes = cart.getDishList();
//        List<OrderDetail> orderDetailList = new ArrayList<>();
//        Order order = new Order();
//        for (DishPOJO dish : dishes) {
//            OrderDetail odb = new OrderDetail();
//            odb.setDishId(dish.getId());
//            odb.setQuantity(new BigDecimal(dish.getOrderedQuantity()));
//            odb.setPricePerUnit(new BigDecimal(dish.getPricePerUnit()));
//            odb.setAmount(new BigDecimal(dish.getOrderedQuantity()).multiply(new BigDecimal(dish.getPricePerUnit())));
//            orderDetailList.add(odb);
//        }
//        order.setSubTotal(cart.getSubTotal());
//        order.setTaxTotal(cart.getTaxTotal());
//        order.setTotal(cart.getTotal());
//        order.setDiscount(cart.getDiscount());
//        order.setOrderDetailList(orderDetailList);
//        order.setPromoCode(promoCode != null ? promoCode.getPromoCode() : null);
//        order.setPromo(cart.getPromoCode());
//        order.setStatus(cart.getStatus());
//        order.setCreatedTs(new Date());
//        return order;
//    }
////    public static String parseImage(){
//
//        class UploadImage extends AsyncTask<Void,Void,String> {
//
//            private ProgressDialog progressDialog;
//            @Override
//            protected void onPreExecute() {
//                super.onPreExecute();
//                progressDialog = ProgressDialog.show(Newdesh.this, "Image is Uploading","Please Wait",false,false);
//            }
//
//            @Override
//            protected String doInBackground(Void... params) {
//                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
//                FixBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
//                byte[] byteArray = byteArrayOutputStream.toByteArray();
//                String ConvertImage = Base64.encodeToString(byteArray, Base64.DEFAULT);
//                ImageProcessClass imageProcessClass = new ImageProcessClass();
//                HashMap<String,String> HashMapParams = new HashMap<String,String>();
//                HashMapParams.put("ImageName", ConvertImage);
//
//                String FinalData = imageProcessClass.ImageHttpRequest(  nstants.IMAGE_NEW_DISH, HashMapParams);
//                return FinalData;
//            }
//
//            @Override
//            protected void onPostExecute(String string1) {
//                super.onPostExecute(string1);
//                progressDialog.dismiss();
//                Toast.makeText(Newdesh.this,string1,Toast.LENGTH_LONG).show();
//            }
//
//        }
//
//        class ImageProcessClass{
//
//            public String ImageHttpRequest(String requestURL,HashMap<String, String> PData) {
//                StringBuilder stringBuilder = new StringBuilder();
//                try {
//                    URL url = new URL(requestURL);
//                    HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//                    httpURLConnection.setReadTimeout(20000);
//                    httpURLConnection.setConnectTimeout(20000);
//                    httpURLConnection.setRequestMethod("POST");
//                    httpURLConnection.setDoInput(true);
//                    httpURLConnection.setDoOutput(true);
//                    OutputStream outputStream = httpURLConnection.getOutputStream();
//                    BufferedWriter bufferedWriter = new BufferedWriter(
//                            new OutputStreamWriter(outputStream, "UTF-rating8"));
//                    bufferedWriter.write(bufferedWriterDataFN(PData));
//                    bufferedWriter.flush();
//                    bufferedWriter.close();
//                    outputStream.close();
//                    int RC = httpURLConnection.getResponseCode();
//                    if (RC == HttpsURLConnection.HTTP_OK) {
//                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
//                        stringBuilder = new StringBuilder();
//                        String RC2;
//                        while ((RC2 = bufferedReader.readLine()) != null){
//                            stringBuilder.append(RC2);
//                        }
//                    }
//
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return stringBuilder.toString();
//            }
//
//            private String bufferedWriterDataFN(HashMap<String, String> HashMapParams) throws UnsupportedEncodingException {
//                StringBuilder stringBuilder = new StringBuilder();
//                for (Map.Entry<String, String> KEY : HashMapParams.entrySet()) {
//                    stringBuilder.append("&");
//                    stringBuilder.append(URLEncoder.encode(KEY.getKey(), "UTF-rating8"));
//                    stringBuilder.append("=");
//                    stringBuilder.append(URLEncoder.encode(KEY.getValue(), "UTF-rating8"));
//                }
//                return stringBuilder.toString();
//            }
//
//        }
//
//    }

}
