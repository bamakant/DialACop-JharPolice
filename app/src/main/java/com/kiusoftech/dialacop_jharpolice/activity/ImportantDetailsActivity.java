package com.kiusoftech.dialacop_jharpolice.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.kiusoftech.dialacop_jharpolice.adapter.ImportantDataAdapter;
import com.kiusoftech.dialacop_jharpolice.Pojo.ImportantData;
import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.database.DialACopDatabase;
import com.kiusoftech.dialacop_jharpolice.entity.FavoriteEntity;

import java.util.ArrayList;
import java.util.List;

public class ImportantDetailsActivity extends AppCompatActivity {

    String designation;
    TextView policeStationtextView;
    ArrayList<ImportantData> importantData;
    ListView listView;
    private Button shareButton,makeFavoriteButton;
    Intent intent;
    private static final String TAG = "Kiu";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        designation = getIntent().getExtras().getString("designation");

        policeStationtextView = (TextView) findViewById(R.id.police_station_textview);

        policeStationtextView.setText(designation);

        shareButton = (Button) findViewById(R.id.share_contact_button);
        makeFavoriteButton = findViewById(R.id.make_favorite_button);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        importantData = new ArrayList<>();

        makeFavoriteButtonVisibility();

        switch (designation){

            case "dgp":
                importantData.add(new ImportantData("Shri. D. K. Pandey","09431700097","06512400737","06512361316","06512400738","dgp@jhpolice.gov.in"));
                break;
            case "addl. d.g. (hq)":
                importantData.add(new ImportantData("Shri. Ajay Bhatnagar","N.A.","06512446048","N.A.","06512400079","adg-hq@jhpolice.gov.in"));
                break;
            case "addl. d.g. (trg and mod)":
                importantData.add(new ImportantData("Shri. Anil Palta","07781001777","06512400721","0651244032","06512400998","adg-mod@jhpolice.gov.in"));
                break;
            case "addl. d.g. (ops)":
                importantData.add(new ImportantData("Shri. R. K. Mallick","09431139001","06512400895","06512231133","06512400782","adg-ops@jhpolice.gov.in"));
                break;
            case "ig (hq)":
                importantData.add(new ImportantData("Shri. M. L. Meena","N.A.","N.A.","N.A.","N.A.","ig-hq@jhpolice.gov.in"));
                break;
            case "ig training":
                importantData.add(new ImportantData("Smt. Priya Dubey","N.A.","06512400744","N.A.","06512400728","ig-trg@jhpolice.gov.in"));
                break;
            case "ig (prov)":
                importantData.add(new ImportantData("Shri. Arun Kumar Singh","N.A.","06512400722","N.A.","06512400909","ig-prov@jhpolice.gov.in"));
                break;
            case "ig (ops)":
                importantData.add(new ImportantData("Shri. Ashish Batra","N.A.","06512400729","06512400998","06512401905","ig-ops@jhpolice.gov.in"));
                break;
            case "ig (hr)":
                importantData.add(new ImportantData("Shri. Navin Kr. Singh","N.A.","06512400783","N.A.","06512400083","ig-hr@jhpolice.gov.in"));
                break;
            case "dig (budget)":
                importantData.add(new ImportantData("Shri. Praveen Kr. Srivastava","N.A.","06512400090","06512490060","06512400612","dig-budget@jhpolice.gov.in"));
                break;
            case "ig (p)":
                importantData.add(new ImportantData("Shri. Upendra Kumar","N.A.","06512400731","06512544432","06512401836","dig-p@jhpolice.gov.in"));
                break;
            case "aig cum spl assistant to dgp":
                importantData.add(new ImportantData("Dr. Shams Tabrez","09470138834","06512400783","N.A.","06512400083","aig-dgp@jhpolice.gov.in"));
                break;
            case "director fsl":
                importantData.add(new ImportantData("Shri. A. K. Bapuli","099399110424","06512270016","06512490944","06512270095","director-fsl@jhpolice.gov.in"));
                break;
            case "supervisor ciat school":
                importantData.add(new ImportantData("Shri. A. R. Sinha","09431103538","06512401906","06512413608","06512401906","N.A."));
                break;
            case "sysp. security mantralaya":
                importantData.add(new ImportantData("N.A.","N.A.","06512400734","N.A.","N.A.","N.A."));
                break;
            case "dy. sp (h.q.r.t.)":
                importantData.add(new ImportantData("Shri. Benjamin Kindo","09631083237","06512491570","N.A.","N.A.","N.A."));
                break;
            case "sgt. major hq":
                importantData.add(new ImportantData("Shri. Abhinav Kumar","09304055459","06512400897","N.A.","N.A.","N.A."));
                break;
            case "dg control room":
                importantData.add(new ImportantData("DG Control Room","N.A.","06512446607","N.A.","06512446605","dgp-control@jhpolice.gov.in"));
                break;
            case "khukri kutir":
                importantData.add(new ImportantData("Khukri Kutir","09470149342","06512482193","N.A.","N.A.","N.A."));
                break;
            case "data centre":
                importantData.add(new ImportantData("Data Centre","N.A.","06512400784","N.A.","N.A.","N.A."));
                break;
            case "web support":
                importantData.add(new ImportantData("Web Support","N.A.","06512400784","N.A.","N.A.","N.A."));
                break;

            // police headquarter end
            // home department start

            case "chief secretary":
                importantData.add(new ImportantData("Smt. Rajbala Verma","09771465939","06512400240","N.A.","06512400255","N.A."));
                break;
            case "home secretary":
                importantData.add(new ImportantData("Shri. S. K. G. Rahate","09431707711","06512400220","06512442003","06512400230","N.A."));
                break;
            case "spl. secretary":
                importantData.add(new ImportantData("Smt. Tadasha Mishra","N.A.","06512400700","06512482914","06512400230","N.A."));
                break;
            case "joint secretary":
                importantData.add(new ImportantData("N.A.","09431145802","06512400949","N.A.","N.A.","N.A."));
                break;
            case "finance secretary":
                importantData.add(new ImportantData("N.A.","N.A.","06512400224","N.A.","06512400726","N.A."));
                break;
            case "principle secretary to c.m.":
                importantData.add(new ImportantData("Shri. Sanjay Kumar","09431104455","06512400249","N.A.","N.A.","N.A."));
                break;

            // home department end
            // acb start

            case "adgp cum chief of acb":
                importantData.add(new ImportantData("Shri. P.R.K. Naidu","09431172045","06512281530","N.A.","06512281570","N.A."));
                break;
            case "ig vigilance":
                importantData.add(new ImportantData("N.A.","09431172045","06512281530","N.A.","06512281570","ig-vig@jhpolice.gov.in"));
                break;
            case "sp vigilance (1)":
                importantData.add(new ImportantData("Shri. Niranjan Prasad","09431389592","06512281112","N.A.","N.A.","N.A."));
                break;
            case "sp vigilance (2)":
                importantData.add(new ImportantData("Shri. Manoj Kr. Singh","09431108671","06512282667","N.A.","N.A.","N.A."));
                break;
            case "sp vigilance (3)":
                importantData.add(new ImportantData("Shri. Asim Vikrant Minj","09431106962","06512281334","N.A.","N.A.","N.A."));
                break;
            case "sp vigilance (4)":
                importantData.add(new ImportantData("Shri. Sudarshan Mandal","09471736874","N.A.","N.A.","N.A.","N.A."));
                break;
            case "addl. sp":
                importantData.add(new ImportantData("N.A.","N.A.","06512282770","N.A.","N.A.","N.A."));
                break;

            // acb end
            // jap start

            case "adg jap (1)":
                importantData.add(new ImportantData("Shri. Rezi Dungdung","09431170704","06512490145","06512490112","06512490143","adg-jap@jhpolice.gov.in"));
                break;
            case "adg jap (2)":
                importantData.add(new ImportantData("Shri. Anand Prakash","09955239695","N.A.","N.A.","N.A.","N.A."));
                break;
            case "adg jap (3)":
                importantData.add(new ImportantData("Shri. Asim Kumar Das Gupta","09431102268","N.A.","0797791700","N.A.","N.A."));
                break;
            case "ig jap":
                importantData.add(new ImportantData("N.A.","N.A.","06512491551","N.A.","06512491450","ig-jap@jhpolice.gov.in"));
                break;
            case "dig jap":
                importantData.add(new ImportantData("Shri. Sudhir Kr. Jha","09939602900","06512490011","N.A.","06512490011","dig-jap@jhpolice.gov.in"));
                break;
            case "co jap-01":
                importantData.add(new ImportantData("Smt. Kusum Punia","N.A.","06512481382","06512490306","06512480293","co-jap01@jhpolice.gov.in"));
                break;
            case "co jap-02":
                importantData.add(new ImportantData("Shri. Sanjay Kumar","9934348536","06512265844","06512265858","06512265844","co-jap02@jhpolice.gov.in"));
                break;
            case "co jap-03":
                importantData.add(new ImportantData("Smt. Nidhi Dwivedi","9955083388","0651262385","06512202025","0651262018","co-jap03@jhpolice.gov.in"));
                break;
            case "co jap-04":
                importantData.add(new ImportantData("Naushad Alam","9934337040","06542256649","N.A.","N.A.","co-jap04@jhpolice.gov.in"));
                break;
            case "co jap-05":
                importantData.add(new ImportantData("Mis. Sujata Kumari Veenapani","9470591079","064322260999","06432290132","06432260999","co-jap05@jhpolice.gov.in"));
                break;
            case "co jap-06":
                importantData.add(new ImportantData("Smt. Sangeeta Kumari","08986882284","06572211013","06572443016","06572213613","co-jap06@jhpolice.gov.in"));
                break;
            case "co jap-07":
                importantData.add(new ImportantData("Shri. Devendra Thakur","09431706556","06546264444","06546265701","06546267765","co-jap07@jhpolice.gov.in"));
                break;
            case "co jap-08":
                importantData.add(new ImportantData("Shri. Madan Mohan Lal","09431706115","06562282006","06562282755","06562282756","co-jap08@jhpolice.gov.in"));
                break;
            case "co jap-09":
                importantData.add(new ImportantData("Shri. Kumar Ravi Shankar","09973507991","06436222432","N.A.","N.A.","co-jap09@jhpolice.gov.in"));
                break;
            case "co jap-10":
                importantData.add(new ImportantData("Smt. Sandhiyarani Mehta","09431708614","06512270005","N.A.","06512270006","co-jap10@jhpolice.gov.in"));
                break;
            case "co-irb-1 (jamtara)":
                importantData.add(new ImportantData("Shri. Biraj Mohan Paswan","09934316866","N.A.","N.A.","N.A.","co-irb01@jhpolice.gov.in"));
                break;
            case "co-irb-2 (musabani)":
                importantData.add(new ImportantData("Shri. Shailendra pd. Barnwal","09471377831","06585275800","N.A.","N.A.","co-irb02@jhpolice.gov.in"));
                break;
            case "co-irb-3 (chatra)":
                importantData.add(new ImportantData("Shri. Madan Mohan Lal","09470197315","06531261241","06531261242","N.A.","co-irb03@jhpolice.gov.in"));
                break;
            case "co-irb-4 (latehar)":
                importantData.add(new ImportantData("Shri. Dhananjay Kr. Singh","07779998290","06562282633","06562282755","N.A.","co-irb04@jhpolice.gov.in"));
                break;
            case "co-irb-5 (gumla)":
                importantData.add(new ImportantData("Shri. Bhimsen Tuti","09431109012","06512402039","N.A.","N.A.","co-irb05@jhpolice.gov.in"));
                break;
            case "khukri guest house":
                importantData.add(new ImportantData("jap-1 guest house","N.A.","06512482193","N.A.","N.A.","N.A."));
                break;
            case "co sisf":
                importantData.add(new ImportantData("Naushad Alam","09430715135","N.A.","N.A.","N.A.","N.A."));
                break;

            // jap end
            // hazaribagh range start

            case "dig hazaribagh":
                importantData.add(new ImportantData("Shri. Bhimsen Tuti","09431706131","06546224804","06546264515","06546264803","dig-hazaribagh@jhpolice.gov.in"));
                break;
            case "sp hazaribagh":
                importantData.add(new ImportantData("Shri. Anup Birthare","09431706297","06546224815","06546264816","065462263000","sp-hazaribagh@jhpolice.gov.in"));
                break;
            case "sp chatra":
                importantData.add(new ImportantData("Shri. Anjani Kr Jha","09431706359","06541223037","06541224564","06541223035","sp-chatra@jhpolice.gov.in"));
                break;
            case "sp koderma":
                importantData.add(new ImportantData("Shri. Surendra Kumar Jha","09431706350","06534252227","06534252868","065342525868","sp-koderma@jhpolice.gov.in"));
                break;
            case "sp giridih":
                importantData.add(new ImportantData("Shri. Akhilesh B Variar","09431706326","06532222056","06532222054","06532222561","sp-giridih@jhpolice.gov.in"));
                break;
            case "sp ramgarh":
                importantData.add(new ImportantData("Shri. Kishore Kaushal","09431706113","06553231455","06553230400","06553230400","dig-hazaribagh@jhpolice.gov.in"));
                break;

            // hazaribagh range end
            // cid start

            case "addl. d.g. (cid)":
                importantData.add(new ImportantData("Shri. Ajay Kr. Singh","09771432100","06512490546","N.A.","06512490295","adg-cid@jhpolice.gov.in"));
                break;
            case "ig org. crime":
                importantData.add(new ImportantData("Smt. Sampat Meena","09771432101","06512490046","N.A.","06512490046","ig-orgcid@jhpolice.gov.in"));
                break;
            case "ig":
                importantData.add(new ImportantData("Smt. Sampat Meena","09771432101","06512491532","N.A.","06512491315","ig-cid@jhpolice.gov.in"));
                break;
            case "dig cid":
                importantData.add(new ImportantData("N.A.","N.A.","06512490532","N.A.","N.A.","dig-cid@jhpolice.gov.in"));
                break;
            case "sp (1)":
                importantData.add(new ImportantData("N.A.","09771432108","N.A.","N.A.","N.A.","N.A."));
                break;
            case "sp (2)":
                importantData.add(new ImportantData("N.A.","09771432104","N.A.","N.A.","N.A.","N.A."));
                break;
            case "sp (3)":
                importantData.add(new ImportantData("N.A.","09771432105","N.A.","N.A.","N.A.","N.A."));
                break;
            case "sp (crime and ops)":
                importantData.add(new ImportantData("Shri. Narendra Kr. Singh","09771432110","06512490710","N.A.","06512490295","N.A."));
                break;
            case "asp":
                importantData.add(new ImportantData("N.A.","09771432107","06512490050","N.A.","N.A.","N.A."));
                break;

            // cid end
            // railways start

            case "addl. dg railway":
                importantData.add(new ImportantData("Shri. Prashant Singh","N.A.","06512490548","06512444703","06512490548","dg-rly@jhpolice.gov.in"));
                break;
            case "ig railway":
                importantData.add(new ImportantData("Smt. Suman Gupta","N.A.","N.A.","N.A.","N.A.","N.A."));
                break;
            case "dig railway":
                importantData.add(new ImportantData("Shri. Jitendra Kr Singh","N.A.","06512462217","NA","06512462077","dig-rly@jhpolice.gov.in"));
                break;
            case "srp ranchi":
                importantData.add(new ImportantData("NA","08294010500","NA","NA","NA","NA"));
                break;
            case "srp jamshedpur":
                importantData.add(new ImportantData("Shri. Anshuman Kumar","09431303400","06572293311","06572431009","06572290111","srp-jsr@jhpolice.gov.in"));
                break;
            case "srp dhanbad":
                importantData.add(new ImportantData("Shri. Hardeep P. Janardan","09431706117","03262312559","03262310250","03262310250","srp-dhn@jhpolice.gov.in"));
                break;
            case "grp hatia":
                importantData.add(new ImportantData("NA","07091374777","06512600092","NA","NA","NA"));
                break;
            case "grp ranchi":
                importantData.add(new ImportantData("NA","09199508052","06512462771","NA","NA","NA"));
                break;
            case "grp bokaro":
                importantData.add(new ImportantData("NA","09431638142","06542253290","NA","NA","NA"));
                break;

            // railways end
            // scrb start

            case "dig scrb":
                importantData.add(new ImportantData("Shri. Hemant Toppo","NA","06512444077","NA","06512444077","NA"));
                break;
            case "sp scrb":
                importantData.add(new ImportantData("Shri. M. K. Mitu","09431706436","06512491350","06512443009","06512491350","NA"));
                break;

            // scrb end
            // wireless start

            case "dig (wireless)":
                importantData.add(new ImportantData("Shri. Mritunjay Kumar","NA","06512218400","NA","06512201919","dig-wireless@jhpolice.gov.in"));
                break;
            case "sp (wireless)":
                importantData.add(new ImportantData("Shri. Chandra Shekhar Prasad","09470590862","06512201919","NA","06512201919","NA"));
                break;
            case "addl. sp (wireless)":
                importantData.add(new ImportantData("NA","09470590845","06512202344","NA","06512202344","NA"));
                break;

            // wireless end
            // jharkhand jaguar start

            case "ig stf":
                importantData.add(new ImportantData("Shri. Ravi Kant Dhan","NA","06512444610","NA","06512444608","ig-stf@jhpolice.gov.in"));
                break;
            case "dig addl. charge":
                importantData.add(new ImportantData("Shri. Saket Kr. Singh","NA","0651244691","NA","NA","dig-stf@jhpolice.gov.in"));
                break;
            case "sp stf":
                importantData.add(new ImportantData("Shri. Anuranjan Kispotta","NA","06512444612","NA","06512444608","sp-stf@jhpolice.gov.in"));
                break;
            case "sp ops":
                importantData.add(new ImportantData("NA","09470590806","NA","NA","NA","NA"));
                break;
            case "dy. sp (adm.)":
                importantData.add(new ImportantData("NA","09470590808","NA","NA","NA","NA"));
                break;
            case "dy. sp (trg.)":
                importantData.add(new ImportantData("Shri. Ashok Kr. Ghosh","09570001619","NA","NA","NA","NA"));
                break;
            case "jj control room":
                importantData.add(new ImportantData("JJ Control Room","NA","06512444609","NA","06512444608","NA"));
                break;

            // jharkhand jaguar end
            // Kolhan range start

            case "dig chaibasa":
                importantData.add(new ImportantData("Shri. Saket Kr. Singh","09431706135","06582257999","06582258333","06582257999","dig-chaibasa@jhpolice.gov.in"));
                break;
            case "sp chaibasa":
                importantData.add(new ImportantData("Shri. Anish Gupta","09431706451","06582256305","06582256304","06582259726","sp-chaibasa@jhpolice.gov.in"));
                break;
            case "ssp jamshedpur":
                importantData.add(new ImportantData("Shri. Anoop T. Maithu","09431706480","06572431006","06572231005","06572440170","ssp-jsr@jhpolice.gov.in"));
                break;
            case "sp city jamshedpur":
                importantData.add(new ImportantData("Shri. Prashant Anand","09471190203","06572437666","06572234711","NA","spcity-jsr@jhpolice.gov.in"));
                break;
            case "sp rural jamshedpur":
                importantData.add(new ImportantData("Shri. Prabhat Kumar","09470199228","06572234000","06572235113","NA","sprural-jsr@jhpolice.gov.in"));
                break;
            case "sp saraikela":
                importantData.add(new ImportantData("Shri. Chandan Kr. Sinha","09431706529","06597234004","06597234005","06597234830","sp-saraikela@jhpolice.gov.in"));
                break;

            // kolhan range end
            // home guard start

            case "dg (h.g. and f.s.)":
                importantData.add(new ImportantData("Shri. B B Pradhan","09431140900","06512490615","NA","06512490608","dg-hg@jhpolice.gov.in"));
                break;
            case "dig (h.g. and f.s.)":
                importantData.add(new ImportantData("Shri. Sudhir Kr. Jha","09955091500","06512490101","NA","06512490608","dig-hg@jhpolice.gov.in"));
                break;
            case "sp hg":
                importantData.add(new ImportantData("Shri. Deepak Kr. Sinha","09471522223","06512490608","NA","06512490608","sp-hg@jhpolice.gov.in"));
                break;
            case "state fire officer":
                importantData.add(new ImportantData("Shri. Ram Krishna Thakur","09430136101","06512491668","NA","NA","NA"));
                break;

            // home guard end
            // Bokaro range start

            case "dig bokaro":
                importantData.add(new ImportantData("Shri. Prabhat Kumar","08987786099","06542232344","06542232244","06542232244","dig-bokaro@jhpolice.gov.in"));
                break;
            case "ssp dhanbad":
                importantData.add(new ImportantData("Shri. Manoj Ratan Chothe","09431120900","03262220802","03262312605","03262312606","sp-dhanbad@jhpolice.gov.in"));
                break;
            case "sp city dhanbad":
                importantData.add(new ImportantData("Shri. Piyush Pandey","09431743111","NA","NA","NA","citysp-dhanbad@jhpolice.gov.in"));
                break;
            case "sp rural dhanbad":
                importantData.add(new ImportantData("Shri. Ashutosh Shekhar","09905045056","NA","NA","NA","sprural-dhanbad@jhpolice.gov.in"));
                break;
            case "sp bokaro":
                importantData.add(new ImportantData("Shri. Y. S. Ramesh","09431706418","06542242299","06542242266","06542242266","sp-bokaro@jhpolice.gov.in"));
                break;

            // bokaro range end
            // special branch start

            case "addl. d.g. sb":
                importantData.add(new ImportantData("Shri. Anurag Gupta","09431141999","06512400989","NA","06512400990","adg-sb@jhpolice.gov.in"));
                break;
            case "ig sb":
                importantData.add(new ImportantData("NA","NA","06512400727","NA","06512400766","ig-sb@jhpolice.gov.in"));
                break;
            case "dig sb":
                importantData.add(new ImportantData("Shri. Shambhu Thakur","09771400649","06512401938","06512340148","NA","dig-sb@jhpolice.gov.in"));
                break;
            case "sp (estt)":
                importantData.add(new ImportantData("Shri. Michaelraj S","09771400800","06512400986","06512551144","NA","NA"));
                break;
            case "sp (n)":
                importantData.add(new ImportantData("Shri. Kranti Kr. Gadideshi","09771400461","06512400623","NA","06512400766","NA"));
                break;
            case "sp (cm security)":
                importantData.add(new ImportantData("Shri. Shailendra Kr. Sinha","09934348536","NA","NA","NA","NA"));
                break;
            case "dy. sp (tech)-01":
                importantData.add(new ImportantData("Shri. Arif Ekram","09771421188","06512400992","NA","NA","NA"));
                break;
            case "dy. sp (tech)-02":
                importantData.add(new ImportantData("Shri. Pramod Kr. Keshri","09771430136","06512400994","NA","NA","NA"));
                break;
            case "dy. sp control":
                importantData.add(new ImportantData("Shri. Orien James Paridhiya","09771400805","NA","NA","NA","NA"));
                break;
            case "dy. sp raj bhawan":
                importantData.add(new ImportantData("Smt. Sarijini Lakra","08877700400","NA","NA","NA","NA"));
                break;
            case "dy. sp cm security":
                importantData.add(new ImportantData("Shri. Avinash Kumar","09771400526","NA","NA","NA","NA"));
                break;
            case "dy. sp (sb)":
                importantData.add(new ImportantData("Shri. Arvind Kr. Sinha","07766906566","NA","NA","NA","NA"));
                break;
            case "sgt. major":
                importantData.add(new ImportantData("Shri. Subodh Kr. Gupta","09771408885","NA","NA","NA","NA"));
                break;
            case "sb control room":
                importantData.add(new ImportantData("SB Control Room","NA","06512400996","NA","NA","NA"));
                break;
            case "state control room":
                importantData.add(new ImportantData("State Control Room","09771400805","06512401879","NA","06512401882","NA"));
                break;
            case "project building":
                importantData.add(new ImportantData("Project Building","09771400465","06512401879","NA","06512401880","NA"));
                break;

            // special branch end
            // JPHC start

            case "dg cum md":
                importantData.add(new ImportantData("Shri. K. S. Meena","09431107966","NA","NA","NA","NA"));
                break;
            case "addl. d.g.":
                importantData.add(new ImportantData("NA","09431107966","06512212627","NA","06512212627","NA"));
                break;
            case "chief engineer":
                importantData.add(new ImportantData("Shri. Suman Kumar","09835500679","06512304712","NA","NA","NA"));
                break;
            case "accountant":
                importantData.add(new ImportantData("Shri. A K Sinha","09431102744","0651221206","NA","NA","NA"));
                break;

            // jhpc end
            // palamu range

            case "dig palamu":
                importantData.add(new ImportantData("Shri. Vipul Shukla","NA","06562231299","06562224300","06562222888","dig-palamu@jhpolice.gov.in"));
                break;
            case "sp palamu":
                importantData.add(new ImportantData("Shri. Indrajit Mahatha","09431706238","06562224023","06562231111","06562231222","sp-palamu@jhpolice.gov.in"));
                break;
            case "sp latehar":
                importantData.add(new ImportantData("Shri. Dhananjay Singh","09431706262","06565247474","06565247475","06565247385","sp-latehar@jhpolice.gov.in"));
                break;
            case "sp garhwa":
                importantData.add(new ImportantData("MD. Arshi","09431706281","06561222314","06561222229","06561222500","sp-garhwa@jhpolice.gov.in"));
                break;

            // palamu end
            // training start

            case "addl. d.g. (training and mod)":
                importantData.add(new ImportantData("Shri. Anil Palta","NA","NA","NA","NA","dg-trg@jhpolice.gov.in"));
                break;
            case "ig, training":
                importantData.add(new ImportantData("Smt. Priya Dubey","NA","06512400744","06512232338","06512400728","dig-palamu@jhpolice.gov.in"));
                break;
            case "dig jungle warfare school":
                importantData.add(new ImportantData("Shri. Nagendra Chaudhary","09431706131","NA","NA","NA","dig-jwfs@jhpolice.gov.in"));
                break;
            case "director jharkhand police academy":
                importantData.add(new ImportantData("Shri. Deo Bihari Sharma","NA","NA","MA","NA>","director-jpa@jhpolice.gov.in"));
                break;
            case "sp japtc (1)":
                importantData.add(new ImportantData("Shri. Ajay Linda","09431381207","06546270395","06546264515","06546270048","dig-ptc@jhpolice.gov.in"));
                break;
            case "sp japtc (2)":
                importantData.add(new ImportantData("Shri. Nirmal Kr. Mishra","09431141187","06546238042","06546238100","06546238100","sp-japtc@jhpolice.gov.in"));
                break;
            case "principle tts":
                importantData.add(new ImportantData("Shri. Anil Kumar Verma","09431111565","06572270604","NA","06572270604","NA"));
                break;
            case "sp jwf school":
                importantData.add(new ImportantData("Shri. Kumar Ravi Shankar","09973507991","NA","NA","NA","NA"));
                break;
            case "dy. sp":
                importantData.add(new ImportantData("Shri. Ranbir Minj","09431116164","NA","NA","NA","NA"));
                break;

            // training end
            // chhotanagpur range start

            case "dig ranchi":
                importantData.add(new ImportantData("Shri. Homkar Amol Venukant","NA","06512210056","NA","06512212195","dig-ranchi@jhpolice.gov.in"));
                break;
            case "ssp ranchi":
                importantData.add(new ImportantData("Shri. Kuldeep Dwivedi","09431706136","06512200237","06512360102","06512361127","ssp-ranchi@jhpolice.gov.in"));
                break;
            case "sp ranchi rural":
                importantData.add(new ImportantData("Shri. Raj Kr. Lakra","09431706138","06512200238","06512360324","06512215028","sprural-ranchi@jhpolice.gov.in"));
                break;
            case "sp city ranchi":
                importantData.add(new ImportantData("Shri. Aman Kumar","09431706137","06512200898","06512360192","06512207817","spcity-ranchi@jhpolice.gov.in"));
                break;
            case "sp traffic ranchi":
                importantData.add(new ImportantData("Shri. Sanjay Ranjan Singh","09431706140","06512206266","NA","NA","sptraffic-ranchi@jhpolice.gov.in"));
                break;
            case "sp lohardaga":
                importantData.add(new ImportantData("Shri. Kartik S.","09431706218","06526224070","06526222370","06526224097","sp-lohardaga@jhpolice.gov.in"));
                break;
            case "sp gumla":
                importantData.add(new ImportantData("Shri. Chandan Kr. Jha","09431706376","06524223091","06524223092","06524221835","sp-gumla@jhpolice.gov.in"));
                break;
            case "sp simdega":
                importantData.add(new ImportantData("Shri. Rajeev Ranjan Singh","09431116444","06525225703","06525225704","06525225699","sp-simdega@jhpolice.gov.in"));
                break;
            case "sp khunti":
                importantData.add(new ImportantData("Shri. Ashwini Kr. Sinha","09431706116","06528221674","06528221669","06528221660","sp-khunti@jhpolice.gov.in"));
                break;

            // chhotanagpur range end
            // dumka range start

            case "dig dumka":
                importantData.add(new ImportantData("Shri. Akhilesh Kr. Jha","NA","06534222207","06534222217","06534222217","dig-dumka@jhpolice.gov.in"));
                break;
            case "sp dumka":
                importantData.add(new ImportantData("Shri. Mayur Patel Kanhiya Lal","09470591001","06534222216","06534222226","06534237403","sp-dumka@jhpolice.gov.in"));
                break;
            case "sp jamtara":
                importantData.add(new ImportantData("Smt. Jaya Roy","09431130811","06533222020","06533222021","06533223096","sp-jamtara@jhpolice.gov.in"));
                break;
            case "sp deoghar":
                importantData.add(new ImportantData("Smt. A. Vijaya Laxmi","09470591079","06532232733","06532232777","06532232777","sp-deoghar@jhpolice.gov.in"));
                break;
            case "sp pakur":
                importantData.add(new ImportantData("Shri. Shailendra Pd. Barnwal","09431137400","06535222091","06535222269","06535221216","sp-pakur@jhpolice.gov.in"));
                break;
            case "sp sahebganj":
                importantData.add(new ImportantData("Shri. P. Murugun","09470591081","06536222160","06536222033","06536222033","sp-sahebganj@jhpolice.gov.in"));
                break;
            case "sp godda":
                importantData.add(new ImportantData("Shri. Hari Lal Chouhan","09431134800","06522222008","06522222188","06522222188","sp-godda@jhpolice.gov.in"));
                break;

            // dumka range

            // name mobile office residence fax email

        }

        ImportantDataAdapter dataAdapter = new ImportantDataAdapter(ImportantDetailsActivity.this, importantData);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(dataAdapter);

        View v = dataAdapter.getView(0, null, listView);


        final TextView PersonName = (TextView) v.findViewById(R.id.personName_TextView);
        final TextView MobileNo = (TextView) v.findViewById(R.id.location_mobile_textview);
        final TextView OfficeNo = (TextView) v.findViewById(R.id.location_officeno_textview);
        final TextView ResidenceNo = (TextView) v.findViewById(R.id.location_residenceno_textview);
        final TextView FaxNo = (TextView) v.findViewById(R.id.location_faxno_textview);
        final TextView Email = (TextView) v.findViewById(R.id.location_email_textview);


        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Contact Details:\n" +
                        " Designation : " + designation +
                        "\n Name : " + PersonName.getText().toString()
                        + "\n Mobile No : " + MobileNo.getText().toString()
                        + "\n Office No : " + OfficeNo.getText().toString()
                        + "\n Residence No : " + ResidenceNo.getText().toString()
                        + "\n Fax No : "+ FaxNo.getText().toString()
                        + "\n Email ID : "+ Email.getText().toString()
                        + "\nDownload the app now :" +
                        "\nhttps://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Contact Sharing");
                startActivity(Intent.createChooser(intent, "Share Contact"));
            }
        });

        makeFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                makeImportantFav();
            }
        });

    }
    private List<FavoriteEntity> checkFavoriteTable;
    private void makeFavoriteButtonVisibility() {

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

               checkFavoriteTable = DialACopDatabase.getAppDatabase(getApplicationContext()).favoriteEntityDao().checkInFavoriteEntity(designation);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                if (!checkFavoriteTable.isEmpty()){
                    makeFavoriteButton.setVisibility(View.GONE);
                }
            }
        }.execute();

    }

    private void makeImportantFav() {

        new AsyncTask<Void, Void, Void>(){
            @Override
            protected Void doInBackground(Void... voids) {

                FavoriteEntity favorites = new FavoriteEntity();

                favorites.setFavoriteItemTitle(designation);
                favorites.setIdentifier(2);

                long[] insertedImportant = DialACopDatabase.getAppDatabase(getApplicationContext()).favoriteEntityDao().insertFavoriteEntity(favorites);

                Log.d(TAG,"inserted Important : "+insertedImportant.length );

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                makeFavoriteButton.setVisibility(View.GONE);
                Toast.makeText(ImportantDetailsActivity.this,designation.toUpperCase() +" Added to Favorites.", Toast.LENGTH_SHORT).show();
            }
        }.execute();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    //for back button and option menu item click event
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.exit:
                this.finishAffinity();
                return true;
            case R.id.help:
                Intent i = new Intent(ImportantDetailsActivity.this,AboutActivity.class);
                startActivity(i);
                return true;
            case R.id.share:
                intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Check out this App of Jharkhand Police, A small initiative to connect people of jharkhand state with jharkhand police.\n" +
                        "https://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Check out this Apps!");
                startActivity(Intent.createChooser(intent, "Share"));
                return true;
            case R.id.feedback:
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + "kiusoftech@gmail.com"));
                intent.putExtra(Intent.EXTRA_SUBJECT, "Regarding DialACop Jharkhand police Android App");
                intent.putExtra(Intent.EXTRA_TEXT, "Write your suggestion please.\n");
                startActivity(intent);
                return true;
            case R.id.rateapp:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=com.kiusoftech.dialacop_jharpolice")));
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
