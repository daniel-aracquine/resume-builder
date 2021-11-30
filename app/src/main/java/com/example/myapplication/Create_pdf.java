package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Create_pdf extends AppCompatActivity {
    DBHelper db;
    String name;
    String email;
    String age;
    String job;
    String phnNo;
    String linkedin;
    String school10;
    String school12;
    String grade10;
    String grade12;
    String year10;
    String year12;
    String uniGrad;
    String gradeGrad;
    String yearGrad;
    String profileDetail;
    String skills;
    String experience;

    Button generatePDFbtn;
    TextView textview;
    //    String[] informationArray=new String[]{"Name","Age","DOB","Address"};
    int pageHeight = 400;
    int pageWidth = 250;

    Bitmap bmp;
    Bitmap scaledbmp;

    private static final int PERMISSION_REQUEST_CODE = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_pdf);
        db= new DBHelper(this);

        Cursor res=db.getdata("name");
        res.moveToNext();
        name=res.getString(0);

        res=db.getdata("email");
        res.moveToNext();
        email=res.getString(0);

        res=db.getdata("age");
        res.moveToNext();
        age=res.getString(0);

        res=db.getdata("date");
        res.moveToNext();
        job=res.getString(0);

        res=db.getdata("phnNo");
        res.moveToNext();
        phnNo=res.getString(0);

        res=db.getdata("address");
        res.moveToNext();
        linkedin=res.getString(0);

        res=db.getdata("grade10");
        res.moveToNext();
        grade10=res.getString(0);

        res=db.getdata("grade12");
        res.moveToNext();
        grade12=res.getString(0);

        res=db.getdata("gradeGrad");
        res.moveToNext();
        gradeGrad=res.getString(0);

        res=db.getdata("year10");
        res.moveToNext();
        year10=res.getString(0);

        res=db.getdata("year12");
        res.moveToNext();
        year12=res.getString(0);

        res=db.getdata("yearGrad");
        res.moveToNext();
        yearGrad=res.getString(0);

        res=db.getdata("school10");
        res.moveToNext();
        school10=res.getString(0);

        res=db.getdata("school12");
        res.moveToNext();
        school12=res.getString(0);

        res=db.getdata("uniGrad");
        res.moveToNext();
        uniGrad=res.getString(0);

        res=db.getdata("profileDetail");
        res.moveToNext();
        profileDetail=res.getString(0);

        res=db.getdata("uniGrad");
        res.moveToNext();
        uniGrad=res.getString(0);

        res=db.getdata("skills");
        res.moveToNext();
        skills=res.getString(0);

        res=db.getdata("experience");
        res.moveToNext();
        experience=res.getString(0);


        generatePDFbtn = findViewById(R.id.button7);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.gfgimage);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 55, 80, false);

//        if (checkPermission()) {
//            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
//        } else {
//            requestPermission();
//        }

//        generatePDFbtn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                // calling method to
//                // generate our PDF file.
//                generatePDF();
//                Toast.makeText(getApplicationContext(), "PDF generated successfully", Toast.LENGTH_SHORT).show();
//            }
//        });
    }

    public void generatePDF(View view) {
//        textview=findViewById(R.id.textView);
        // creating an object variable
        // for our PDF document.
//        Toast.makeText(getApplicationContext(), "PDF generated successfully", Toast.LENGTH_SHORT).show();
        PdfDocument myPdfDocument = new PdfDocument();
        Paint myPaint = new Paint();
        Paint paint = new Paint(); // i added

        PdfDocument.PageInfo myPageInfo1= new PdfDocument.PageInfo.Builder(pageWidth,pageHeight,1).create();
        PdfDocument.Page myPage1= myPdfDocument.startPage(myPageInfo1);
        Canvas canvas = myPage1.getCanvas();

        int startXPosition=10;
        int endXposition=myPageInfo1.getPageWidth()-10;
        int startYPosition=278;
        String[] exp= experience.split("[,]",0);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(12.0f);
        myPaint.setColor(Color.rgb(25,25,112));
        canvas.drawText(name,myPageInfo1.getPageWidth()/32,20,myPaint);


        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(25,25,112));
        canvas.drawText(job,myPageInfo1.getPageWidth()/32,33,myPaint);
//
//        myPaint.setStyle(Paint.Style.STROKE);
//        myPaint.setStrokeWidth(2);
//        canvas.drawRect(183,10,myPageInfo1.getPageWidth()-15,80,myPaint);
//        myPaint.setStrokeWidth(0);
//        myPaint.setStyle(Paint.Style.FILL);
//        canvas.drawText("Photo",195,45,myPaint);


        canvas.drawBitmap(scaledbmp, 183, 10, paint); // i added


//        String profileDetails="2nd Year student at IIITA, Backend Developer having good proficiency in NodeJs,MongoDB and Express and WebD wing member at GeekHaven.";

//        String obj1=profileDetail.substring(0,38);
//        String obj2=profileDetail.substring(38,74);
//        String obj3=profileDetail.substring(74,108);
//        String obj4=profileDetail.substring(108);
//
//        myPaint.setTextAlign(Paint.Align.LEFT);
//        myPaint.setTextSize(7.0f);
//        myPaint.setColor(Color.rgb(105,105, 105));
//        canvas.drawText( obj1,myPageInfo1.getPageWidth()/32,45,myPaint);
//
        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(7.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText(profileDetail,myPageInfo1.getPageWidth()/32,52,myPaint);
//
//        myPaint.setTextAlign(Paint.Align.LEFT);
//        myPaint.setTextSize(7.0f);
//        myPaint.setColor(Color.rgb(105,105, 105));
//        canvas.drawText(obj3,myPageInfo1.getPageWidth()/32,62,myPaint);
//
//        myPaint.setTextAlign(Paint.Align.LEFT);
//        myPaint.setTextSize(8.0f);
//        myPaint.setColor(Color.rgb(105,105, 105));
//        canvas.drawText(obj4,myPageInfo1.getPageWidth()/32,72,myPaint);


        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(11.0f);
        myPaint.setColor(Color.rgb(0,0, 0));
        canvas.drawText("Experience",myPageInfo1.getPageWidth()/32,90,myPaint);

        myPaint.setColor(Color.rgb(169,169,169));
        canvas.drawLine(myPageInfo1.getPageWidth()/32,95,endXposition,95,myPaint);



        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+exp[0],myPageInfo1.getPageWidth()/12,108,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+exp[1],myPageInfo1.getPageWidth()/12,128,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+exp[2],myPageInfo1.getPageWidth()/12,148,myPaint);



        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(11.0f);
        myPaint.setColor(Color.rgb(0,0, 0));
        canvas.drawText("Education",myPageInfo1.getPageWidth()/32,170,myPaint);

        myPaint.setColor(Color.rgb(169,169,169));
        canvas.drawLine(myPageInfo1.getPageWidth()/32,175,endXposition,175,myPaint);


        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("HighSchool     : " +  school10 + " " + year10 + "  " + grade10  ,myPageInfo1.getPageWidth()/12,190,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("Intermediate  : "+ school12 + " " + year12 + "  " + grade12,myPageInfo1.getPageWidth()/12,210,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("Graduation      : "+uniGrad + " " + yearGrad + "  " + gradeGrad,myPageInfo1.getPageWidth()/12,230,myPaint);



        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(11.0f);
        myPaint.setColor(Color.rgb(0,0, 0));
        canvas.drawText("Skills",myPageInfo1.getPageWidth()/32,255,myPaint);

        myPaint.setColor(Color.rgb(169,169,169));
        canvas.drawLine(myPageInfo1.getPageWidth()/32,260,endXposition,260,myPaint);

//        String str="C++,Java,Python,Mongo,Express,Js";
        String[] res = skills.split("[,]", 0);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+ res[0],myPageInfo1.getPageWidth()/12,275,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+ res[1],myPageInfo1.getPageWidth()/12,295,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+res[2],myPageInfo1.getPageWidth()/12,315,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+res[3],myPageInfo1.getPageWidth()/2,275,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+res[4],myPageInfo1.getPageWidth()/2,295,myPaint);

        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(9.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText("* "+res[5],myPageInfo1.getPageWidth()/2,315,myPaint);


        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(11.0f);
        myPaint.setColor(Color.rgb(0,0, 0));
        canvas.drawText("Contact Me",myPageInfo1.getPageWidth()/32,340,myPaint);

        myPaint.setColor(Color.rgb(169,169,169));
        canvas.drawLine(myPageInfo1.getPageWidth()/32,345,endXposition,345,myPaint);



        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(8.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText(email,myPageInfo1.getPageWidth()/32,365,myPaint);



        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(8.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText(linkedin,myPageInfo1.getPageWidth()/32,380,myPaint);



        myPaint.setTextAlign(Paint.Align.LEFT);
        myPaint.setTextSize(8.0f);
        myPaint.setColor(Color.rgb(105,105, 105));
        canvas.drawText(phnNo,2*(myPageInfo1.getPageWidth()/3),365,myPaint);


        myPdfDocument.finishPage(myPage1);

        File file=new File(Environment.getExternalStorageDirectory(),"/resume_"+name+"_"+".pdf");

        try {
            myPdfDocument.writeTo(new FileOutputStream(file));
            Toast.makeText(getApplicationContext(), "PDF generated successfully", Toast.LENGTH_SHORT).show();
        } catch (IOException e)
        {
            e.printStackTrace();
            Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }

        myPdfDocument.close();
    }

//    private boolean checkPermission() {
//        // checking of permissions.
//        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
//        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
//        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
//    }
//
//    private void requestPermission() {
//        // requesting permissions if not provided.
//        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == PERMISSION_REQUEST_CODE) {
//            if (grantResults.length > 0) {
//
//                // after requesting permissions we are showing
//                // users a toast message of permission granted.
//                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
//                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;
//
//                if (writeStorage && readStorage) {
//                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
//                } else {
//                    Toast.makeText(this, "Permission Denined.", Toast.LENGTH_SHORT).show();
//                    finish();
//                }
//            }
//        }
//    }
}