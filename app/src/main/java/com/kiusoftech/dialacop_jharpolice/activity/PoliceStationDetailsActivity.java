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

import com.kiusoftech.dialacop_jharpolice.R;
import com.kiusoftech.dialacop_jharpolice.Pojo.PoliceStationData;
import com.kiusoftech.dialacop_jharpolice.adapter.PoliceStationDataAdapter;
import com.kiusoftech.dialacop_jharpolice.database.DialACopDatabase;
import com.kiusoftech.dialacop_jharpolice.entity.FavoriteEntity;

import java.util.ArrayList;
import java.util.List;

public class PoliceStationDetailsActivity extends AppCompatActivity {

    String policeStation;
    TextView policeStationtextView,phoneText,mobileText;
    ArrayList<PoliceStationData> policeStationData;
    ListView listView;
    private Button shareButton,makeFavoriteButton;
    Intent intent;
    private static final String TAG = "Kiu";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setHomeButtonEnabled(true);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }


        policeStation = getIntent().getExtras().getString("PoliceStationName");

        policeStationtextView = (TextView) findViewById(R.id.police_station_textview);
        shareButton = (Button) findViewById(R.id.share_contact_button);
        makeFavoriteButton = findViewById(R.id.make_favorite_button);

        policeStationtextView.setText(policeStation);

        policeStationData = new ArrayList<>();

        makeFavoriteButtonVisibility();

        //@ load data according to station name passed by intent.

        switch (policeStation) {

            case "oc sc-st":
                policeStationData.add(new PoliceStationData("N.A.", "09835714053"));
                break;
            case "oc penk narayanpur":
                policeStationData.add(new PoliceStationData("N.A.", "09102307266"));
                break;
            case "oc jageswar vihar":
                policeStationData.add(new PoliceStationData("N.A.", "07654748056"));
                break;
            case "oc chattrochati":
                policeStationData.add(new PoliceStationData("N.A.", "07764957761"));
                break;
            case "balidih biyada op":
                policeStationData.add(new PoliceStationData("N.A.", "09534236926"));
                break;
            case "b.t.p.s. ps":
                policeStationData.add(new PoliceStationData("06549266100", "09431706443"));
                break;
            case "gandhinagar ps":
                policeStationData.add(new PoliceStationData("06549260002", "09939312034"));
                break;
            case "mahuatand ps":
                policeStationData.add(new PoliceStationData("06544253129", "07762932916"));
                break;
            case "tenughat op":
                policeStationData.add(new PoliceStationData("06549230401", "09431706437"));
                break;
            case "mahila ps":
                policeStationData.add(new PoliceStationData("06542220016", "09798150624"));
                break;
            case "bhojudih ps":
                policeStationData.add(new PoliceStationData("N.A.", "09199613206"));
                break;
            case "sector-6 ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706429"));
                break;
            case "bokaro jharia op":
                policeStationData.add(new PoliceStationData("N.A.", "08271766263"));
                break;
            case "bermo ps":
                policeStationData.add(new PoliceStationData("06549220202", "09431706436"));
                break;
            case "petarwar ps":
                policeStationData.add(new PoliceStationData("06549265699", "09431706448"));
                break;
            case "amlabad op":
                policeStationData.add(new PoliceStationData("N.A.", "09263638478"));
                break;
            case "bangaria op":
                policeStationData.add(new PoliceStationData("N.A.", "08651037838"));
                break;
            case "barmasia op":
                policeStationData.add(new PoliceStationData("N.A.", "09507308355"));
                break;
            case "b.s. city ps":
                policeStationData.add(new PoliceStationData("06542247832", "09431706424"));
                break;
            case "chas ps":
                policeStationData.add(new PoliceStationData("06542265940", "09431706434"));
                break;
            case "siyaljory ps":
                policeStationData.add(new PoliceStationData("N.A.", "08651102618"));
                break;
            case "sector-12 ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706431"));
                break;
            case "marafari ps":
                policeStationData.add(new PoliceStationData("06542247855", "09431706432"));
                break;
            case "i.e.l. ps":
                policeStationData.add(new PoliceStationData("06544262329", "09431706446"));
                break;
            case "nawadih ps":
                policeStationData.add(new PoliceStationData("06549233066", "09973000638"));
                break;
            case "pindrajora ps":
                policeStationData.add(new PoliceStationData("N.A.", "09934715842"));
                break;
            case "sector-4 ps":
                policeStationData.add(new PoliceStationData("06542233100", "09431706428"));
                break;
            case "harla ps":
                policeStationData.add(new PoliceStationData("06542262170", "9431706430"));
                break;
            case "chas (m) ps":
                policeStationData.add(new PoliceStationData("N.A.", "09199303541"));
                break;
            case "chandankiyari ps":
                policeStationData.add(new PoliceStationData("06542230768", "9939356551"));
                break;
            case "gomia ps":
                policeStationData.add(new PoliceStationData("06544261262", "09431706445"));
                break;
            case "lalpania op":
                policeStationData.add(new PoliceStationData("06544225418", "09199434695"));
                break;
            case "jaridih ps":
                policeStationData.add(new PoliceStationData("06542250020","09431706449"));
                break;
            case "kasmar ps":
                policeStationData.add(new PoliceStationData("06542263307", "09431706450"));
                break;
            case "kathara op":
                policeStationData.add(new PoliceStationData("N.A.", "0919943469"));
                break;
            case "balidih ps":
                policeStationData.add(new PoliceStationData("06542253754", "09431706433"));
                break;
            case "dugdha ps":
                policeStationData.add(new PoliceStationData("06549244099", "09431706442"));
                break;
            case "chandrapura ps":
                policeStationData.add(new PoliceStationData("06549242230", "09431706441"));
                break;
            case "sadar ps":
                policeStationData.add(new PoliceStationData("06541222233", "09431706364"));
                break;
            case "simariya ps":
                policeStationData.add(new PoliceStationData("06559233315", "09431706367"));
                break;
            case "lawalong ps":
                policeStationData.add(new PoliceStationData("N.A.", "07277485621"));
                break;
            case "rajpur ps":
                policeStationData.add(new PoliceStationData("N.A.", "09955313568"));
                break;
            case "gidhaur ps":
                policeStationData.add(new PoliceStationData("N.A.", "09934382031"));
                break;
            case "piparwar ps":
                policeStationData.add(new PoliceStationData("06531260233", "09431706368"));
                break;
            case "tandwa ps":
                policeStationData.add(new PoliceStationData("06559244440", "07762955427"));
                break;
            case "pratappur ps":
                policeStationData.add(new PoliceStationData("06550265501", "09631340500"));
                break;
            case "pathalgadda ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431321460"));
                break;
            case "kunda ps":
                policeStationData.add(new PoliceStationData("N.A.", "0939904770"));
                break;
            case "itkhori ps":
                policeStationData.add(new PoliceStationData("06541266233", "09431706366"));
                break;
            case "hunterganj ps":
                policeStationData.add(new PoliceStationData("06550255240", "09162752962"));
                break;
            case "bashishtnagar ps (jori)":
                policeStationData.add(new PoliceStationData("06549242230", "09431706441"));
                break;

            // chatra end
            //deoghar start

            case "margomunda ps":
                policeStationData.add(new PoliceStationData("N.A.", "09934571284"));
                break;
            case "devipur ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431137631"));
                break;
            case "babamandir ps":
                policeStationData.add(new PoliceStationData("06432232600", "09431137941"));
                break;
            case "mahila ps (deoghar)":
                policeStationData.add(new PoliceStationData("06432232600", "09835751602"));
                break;
            case "chitra ps":
                policeStationData.add(new PoliceStationData("06438264239", "09470591060"));
                break;
            case "palajori ps":
                policeStationData.add(new PoliceStationData("06438274640", "09470591059"));
                break;
            case "sarth ps":
                policeStationData.add(new PoliceStationData("06438254194", "09470591058"));
                break;
            case "karoon ps":
                policeStationData.add(new PoliceStationData("06438256861", "09470591057"));
                break;
            case "madhupur ps":
                policeStationData.add(new PoliceStationData("06438224427", "09470591056"));
                break;
            case "sonaraydhari ps":
                policeStationData.add(new PoliceStationData("06432257307", "09470591055"));
                break;
            case "sarwa ps":
                policeStationData.add(new PoliceStationData("06432288110", "09470591054"));
                break;
            case "mohanpur ps":
                policeStationData.add(new PoliceStationData("06432281024", "09470591053"));
                break;
            case "town ps (deoghar)":
                policeStationData.add(new PoliceStationData("06432232600", "09470591050"));
                break;
            case "kunda ps (deoghar)":
                policeStationData.add(new PoliceStationData("06432225430", "09470591051"));
                break;
            case "jasidih ps":
                policeStationData.add(new PoliceStationData("06432270234", "09470591052"));
                break;
            //deoghar end
            //dhanbad start

            case "ghanuadih op":
                policeStationData.add(new PoliceStationData("N.A.", "07870788674"));
                break;
            case "gonudih op":
                policeStationData.add(new PoliceStationData("N.A.", "08936000043"));
                break;
            case "kharkhari op":
                policeStationData.add(new PoliceStationData("N.A.", "09431915330"));
                break;
            case "bhatdih op":
                policeStationData.add(new PoliceStationData("N.A.", "09234445101"));
                break;
            case "traffic ps":
                policeStationData.add(new PoliceStationData("N.A.", "07739224286"));
                break;
            case "borragarh op":
                policeStationData.add(new PoliceStationData("N.A.", "09955913502"));
                break;
            case "angar pathira op":
                policeStationData.add(new PoliceStationData("N.A.", "09430309815"));
                break;
            case "east basuriya op":
                policeStationData.add(new PoliceStationData("N.A.", "08578879315"));
                break;
            case "purbi tundi ps":
                policeStationData.add(new PoliceStationData("N.A.", "07352374918"));
                break;
            case "maniyadih ps":
                policeStationData.add(new PoliceStationData("N.A.", "09102478794"));
                break;
            case "chirkunda ps":
                policeStationData.add(new PoliceStationData("06540272224", "09431706403"));
                break;
            case "dhanuadih op":
                policeStationData.add(new PoliceStationData("03262361166", "09470967570"));
                break;
            case "lodna op":
                policeStationData.add(new PoliceStationData("03263200005", "09931657545"));
                break;
            case "munidih op":
                policeStationData.add(new PoliceStationData("03262339096", "08298094676"));
                break;
            case "bhagabandh op":
                policeStationData.add(new PoliceStationData("03260339066", "09939576629"));
                break;
            case "goushala op":
                policeStationData.add(new PoliceStationData("03262350545", "08102402922"));
                break;
            case "bhuli op":
                policeStationData.add(new PoliceStationData("03262340262", "09431372663"));
                break;
            case "maithan op":
                policeStationData.add(new PoliceStationData("06540274888", "09431275415"));
                break;
            case "pancheat op":
                policeStationData.add(new PoliceStationData("06540286345", "09934385912"));
                break;
            case "galfarbari op":
                policeStationData.add(new PoliceStationData("06540272748", "09431147153"));
                break;
            case "dharmabandh op":
                policeStationData.add(new PoliceStationData("03262251100", "09470584577"));
                break;
            case "ramkanali op":
                policeStationData.add(new PoliceStationData("03262384284", "09931346689"));
                break;
            case "sonardih op":
                policeStationData.add(new PoliceStationData("03262374399", "07250501453"));
                break;
            case "tisra ps":
                policeStationData.add(new PoliceStationData("03262290100", "09431285582"));
                break;
            case "mahuda ps":
                policeStationData.add(new PoliceStationData("03242221100", "09431706411"));
                break;
            case "madhuban ps":
                policeStationData.add(new PoliceStationData("03262392085", "09431706412"));
                break;
            case "kenduadih ps":
                policeStationData.add(new PoliceStationData("03262330343", "09431706394"));
                break;
            case "bankmore ps":
                policeStationData.add(new PoliceStationData("03262302417", "09431706392"));
                break;
            case "bhonra op":
                policeStationData.add(new PoliceStationData("03262320076", "03262320077"));
                break;
            case "saraidhela ps":
                policeStationData.add(new PoliceStationData("03262201030", "09431706398"));
                break;
            case "jogta ps":
                policeStationData.add(new PoliceStationData("03262372540", "09431706396"));
                break;
            case "loyabod ps":
                policeStationData.add(new PoliceStationData("03262330778", "09431706397"));
                break;
            case "putki ps":
                policeStationData.add(new PoliceStationData("03262330434", "09431706395"));
                break;
            case "dhansar ps":
                policeStationData.add(new PoliceStationData("03262307538", "09431706393"));
                break;
            case "kumardhubi op":
                policeStationData.add(new PoliceStationData("06540272750", "09431706393"));
                break;
            case "nirsa ps":
                policeStationData.add(new PoliceStationData("06540275042", "09431406417"));
                break;
            case "patherdih ps":
                policeStationData.add(new PoliceStationData("03262381707", "09431706417"));
                break;
            case "sudamdih ps":
                policeStationData.add(new PoliceStationData("03262380380", "09431706416"));
                break;
            case "alakhadiha op":
                policeStationData.add(new PoliceStationData("03262361259", "09431706416"));
                break;
            case "jorapokhar ps":
                policeStationData.add(new PoliceStationData("03262381401", "09431706415"));
                break;
            case "baliapur ps":
                policeStationData.add(new PoliceStationData("03262431244", "09431706414"));
                break;
            case "sindri ps":
                policeStationData.add(new PoliceStationData("03262350512", "09431706413"));
                break;
            case "tetulmari ps":
                policeStationData.add(new PoliceStationData("03262374379", "09431706409"));
                break;
            case "barora ps":
                policeStationData.add(new PoliceStationData("03262392185", "09431706410"));
                break;
            case "rajganj op":
                policeStationData.add(new PoliceStationData("03262272320", "09431706408"));
                break;
            case "katras ps":
                policeStationData.add(new PoliceStationData("03262372440", "09431706407"));
                break;
            case "baghmara ps":
                policeStationData.add(new PoliceStationData("03262428376", "09431706404"));
                break;
            case "hariharpur ps":
                policeStationData.add(new PoliceStationData("03262472715", "09431706406"));
                break;
            case "topchanchi ps":
                policeStationData.add(new PoliceStationData("03262482202", "09431706405"));
                break;
            case "barwadda ps":
                policeStationData.add(new PoliceStationData("03262207679", "09431706401"));
                break;
            case "tundi ps":
                policeStationData.add(new PoliceStationData("06540282175", "09431706400"));
                break;
            case "govindpur ps":
                policeStationData.add(new PoliceStationData("06540262255", "09431706415"));
                break;
            //dhanbad end
            // dumka start

            case "muffassil ps":
                policeStationData.add(new PoliceStationData("06434222313", "09470591021"));
                break;
            case "shikaripara ps":
                policeStationData.add(new PoliceStationData("06427268872", "09470591009"));
                break;
            case "town ps":
                policeStationData.add(new PoliceStationData("06434222234", "09470591008"));
                break;
            case "gopikandar ps":
                policeStationData.add(new PoliceStationData("06427251011", "09470591020"));
                break;
            case "kathikund ps":
                policeStationData.add(new PoliceStationData("0642722079", "09470591019"));
                break;
            case "saraiya hat ps":
                policeStationData.add(new PoliceStationData("06431260957", "09470591016"));
                break;
            case "jama ps":
                policeStationData.add(new PoliceStationData("06431258820", "09470591014"));
                break;
            case "raneshwar ps":
                policeStationData.add(new PoliceStationData("06434268605", "09470591010"));
                break;
            case "masliya ps":
                policeStationData.add(new PoliceStationData("06434255002", "09470591011"));
                break;
            case "tongra ps":
                policeStationData.add(new PoliceStationData("06434290123", "09470591012"));
                break;
            case "jarmundih ps":
                policeStationData.add(new PoliceStationData("06431230631", "09470591013"));
                break;
            case "ramgarh ps (dumka)":
                policeStationData.add(new PoliceStationData("06431270050", "09470591018"));
                break;
            case "hansdiha ps":
                policeStationData.add(new PoliceStationData("06431248244", "09470591017"));
                break;
            case "taljhari ps":
                policeStationData.add(new PoliceStationData("06431250022", "09470591015"));
                break;
            case "masanjor op":
                policeStationData.add(new PoliceStationData("06434269033", "09470591022"));
                break;

            //dumka end
            // east singhbhum start

            case "galudih":
                policeStationData.add(new PoliceStationData("N.A.", "09431534577"));
                break;
            case "mango ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706488"));
                break;
            case "sonari ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706507"));
                break;
            case "burmamines ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706513"));
                break;
            case "kadma ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706506"));
                break;
            case "parsudih ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706515"));
                break;
            case "sspur":
                policeStationData.add(new PoliceStationData("N.A.", "09431706521"));
                break;
            case "sundarnagar ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706516"));
                break;
            case "birsanagar ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706512"));
                break;
            case "govindpur ps (jsr)":
                policeStationData.add(new PoliceStationData("N.A.", "09431706511"));
                break;
            case "boram":
                policeStationData.add(new PoliceStationData("N.A.", "09386316294"));
                break;
            case "azadnagar ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706502"));
                break;
            case "telco":
                policeStationData.add(new PoliceStationData("N.A.", "09431706510"));
                break;
            case "jugsalai ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706495"));
                break;
            case "sidhgora ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706508"));
                break;
            case "sitaramdera ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706509"));
                break;
            case "golmuri ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706494"));
                break;
            case "olidih op":
                policeStationData.add(new PoliceStationData("N.A.", "09431706501"));
                break;
            case "moubhandar op":
                policeStationData.add(new PoliceStationData("N.A.", "09431706518"));
                break;
            case "dhalbhumgarh ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706519"));
                break;
            case "bahragora ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706526"));
                break;
            case "bagbera":
                policeStationData.add(new PoliceStationData("N.A.", "09431706514"));
                break;
            case "ghatsila ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706517"));
                break;
            case "dumaria ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706524"));
                break;
            case "potka ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706525"));
                break;
            case "gurubanda ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706528"));
                break;
            case "jadugora ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706523"));
                break;
            case "chakulia":
                policeStationData.add(new PoliceStationData("N.A.", "09431706520"));
                break;
            case "kamalpur":
                policeStationData.add(new PoliceStationData("N.A.", "09431706505"));
                break;
            case "musabani":
                policeStationData.add(new PoliceStationData("N.A.", "09431706522"));
                break;
            case "patamda ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706504"));
                break;
            case "barsol ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706527"));
                break;
            case "mgm ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706503"));
                break;
            case "sakchi ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706491"));
                break;
            case "bistupur ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706497"));
                break;

            // east singhbhum end
            // garhwa start

            case "mahila thana":
                policeStationData.add(new PoliceStationData("N.A.", "09431511570"));
                break;
            case "bardiha":
                policeStationData.add(new PoliceStationData("N.A.", "09835771617"));
                break;
            case "bishunpura":
                policeStationData.add(new PoliceStationData("N.A.", "07677848473"));
                break;
            case "ketar":
                policeStationData.add(new PoliceStationData("N.A.", "08434497121"));
                break;
            case "danda":
                policeStationData.add(new PoliceStationData("N.A.", "08292311784"));
                break;
            case "bhandaria ps":
                policeStationData.add(new PoliceStationData("06581255546", "09431570183"));
                break;
            case "nagar untari ps":
                policeStationData.add(new PoliceStationData("06564252413", "09709071914"));
                break;
            case "hariharpur op":
                policeStationData.add(new PoliceStationData("N.A.", "09939046270"));
                break;
            case "kharondih ps":
                policeStationData.add(new PoliceStationData("N.A.", "09934336920"));
                break;
            case "ramna ps":
                policeStationData.add(new PoliceStationData("N.A.", "08541824127"));
                break;
            case "dandai ps":
                policeStationData.add(new PoliceStationData("N.A.", "09955960566"));
                break;
            case "ramkanda ps":
                policeStationData.add(new PoliceStationData("N.A.", "09835771617"));
                break;
            case "chinia ps":
                policeStationData.add(new PoliceStationData("N.A.", "09708910206"));
                break;
            case "dhurki ps":
                policeStationData.add(new PoliceStationData("N.A.", "09693549957"));
                break;
            case "manjhion ps":
                policeStationData.add(new PoliceStationData("06563287759", "08002831397"));
                break;
            case "bhawnathpur ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431101772"));
                break;
            case "meral ps":
                policeStationData.add(new PoliceStationData("06564228862", "09431362727"));
                break;
            case "kandi ps":
                policeStationData.add(new PoliceStationData("06563265624", "09798311048"));
                break;
            case "ranka ps":
                policeStationData.add(new PoliceStationData("06561254643", "09798546665"));
                break;
            case "garhwa ps":
                policeStationData.add(new PoliceStationData("06561222313", "09471740062"));
                break;

            // garhwa end
            // giridih start

            case "navdiha op":
                policeStationData.add(new PoliceStationData("N.A.", "09572355333"));
                break;
            case "parsan op":
                policeStationData.add(new PoliceStationData("N.A.", "09631527103"));
                break;
            case "madhuban op":
                policeStationData.add(new PoliceStationData("N.A.", "09934639101"));
                break;
            case "khukhra":
                policeStationData.add(new PoliceStationData("N.A.", "09955412301"));
                break;
            case "dumri ps":
                policeStationData.add(new PoliceStationData("06558233232", "09431706344"));
                break;
            case "town ps (giridih)":
                policeStationData.add(new PoliceStationData("06532222777", "09431706343"));
                break;
            case "lokai nayanpur ps":
                policeStationData.add(new PoliceStationData("N.A.", "08986639668"));
                break;
            case "taratand ps":
                policeStationData.add(new PoliceStationData("N.A.", "09693623666"));
                break;
            case "bhelwaghati ps":
                policeStationData.add(new PoliceStationData("N.A.", "09572355333"));
                break;
            case "deori ps":
                policeStationData.add(new PoliceStationData("06556234766", "09431706349"));
                break;
            case "gawan ps":
                policeStationData.add(new PoliceStationData("06556234040", "09431706348"));
                break;
            case "tisri ps":
                policeStationData.add(new PoliceStationData("06556234852", "09431706347"));
                break;
            case "pirtand ps":
                policeStationData.add(new PoliceStationData("06558231249", "09431706346"));
                break;
            case "nimiaghat ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706345"));
                break;
            case "birni ps":
                policeStationData.add(new PoliceStationData("06557244295", "07739466406"));
                break;
            case "bagodar ps":
                policeStationData.add(new PoliceStationData("06557233605", "09431706342"));
                break;
            case "sariya ps":
                policeStationData.add(new PoliceStationData("06557235677", "09431706341"));
                break;
            case "dhanwar ps":
                policeStationData.add(new PoliceStationData("06554235777", "09431706340"));
                break;
            case "hirodih ps":
                policeStationData.add(new PoliceStationData("06554", "09431706339"));
                break;
            case "jamua ps":
                policeStationData.add(new PoliceStationData("06554242278", "09431706338"));
                break;
            case "bengabad ps":
                policeStationData.add(new PoliceStationData("06532236504", "09431706337"));
                break;
            case "ahilyapur ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431706336"));
                break;
            case "gandey ps":
                policeStationData.add(new PoliceStationData("06532239262", "09431706335"));
                break;
            case "muffasil ps":
                policeStationData.add(new PoliceStationData("06532222753", "09431706333"));
                break;

            // giridih end
            // godda start

            case "rajabhitha":
                policeStationData.add(new PoliceStationData("N.A.", "09661853867"));
                break;
            case "hanwara ps":
                policeStationData.add(new PoliceStationData("N.A.", "09661854662"));
                break;
            case "boarijore ps":
                policeStationData.add(new PoliceStationData("06437255130", "09431134789"));
                break;
            case "belbadda ps":
                policeStationData.add(new PoliceStationData("06437261317", "09431134792"));
                break;
            case "mahagama ps":
                policeStationData.add(new PoliceStationData("06437228308", "09431134787"));
                break;
            case "poraiyahat ps":
                policeStationData.add(new PoliceStationData("06422258406", "09431134783"));
                break;
            case "muffasil ps (godda)":
                policeStationData.add(new PoliceStationData("06422222455", "09431134782"));
                break;
            case "town ps (godda)":
                policeStationData.add(new PoliceStationData("06422222027", "09431134781"));
                break;
            case "thakur gangti ps":
                policeStationData.add(new PoliceStationData("06437256616", "09431134790"));
                break;
            case "meharma ps":
                policeStationData.add(new PoliceStationData("06429282263", "09431134791"));
                break;
            case "lalmatia ps":
                policeStationData.add(new PoliceStationData("06437251042", "09431134788"));
                break;
            case "basantrai op":
                policeStationData.add(new PoliceStationData("06437260131", "09431134793"));
                break;
            case "pathargama ps":
                policeStationData.add(new PoliceStationData("06437268611", "09431134786"));
                break;
            case "deodand ps":
                policeStationData.add(new PoliceStationData("N.A.", "09431134784"));
                break;
            case "sunderpahari ps":
                policeStationData.add(new PoliceStationData("06422288116", "09431134785"));
                break;

            // godda end
            // gumla start

            case "sisai ps":
                policeStationData.add(new PoliceStationData("06524255409", "09431706214"));
                break;
            case "basia ps":
                policeStationData.add(new PoliceStationData("06533233349", "09431706211"));
                break;
            case "gumla ps":
                policeStationData.add(new PoliceStationData("06524223026", "09431706206"));
                break;
            case "raidih ps":
                policeStationData.add(new PoliceStationData("06536271336", "09431706210"));
                break;
            case "palkot ps":
                policeStationData.add(new PoliceStationData("06536273391", "09431706215"));
                break;
            case "kamdara ps":
                policeStationData.add(new PoliceStationData("06533232138", "09431706212"));
                break;
            case "ghaghra ps":
                policeStationData.add(new PoliceStationData("06523222454", "09431706207"));
                break;
            case "dumri ps (gumla)":
                policeStationData.add(new PoliceStationData("06535272326", "09431706209"));
                break;
            case "chainpur ps":
                policeStationData.add(new PoliceStationData("06535274446", "09431964846"));
                break;
            case "bharno ps":
                policeStationData.add(new PoliceStationData("06524254454", "09431706213"));
                break;
            case "bishunpur ps":
                policeStationData.add(new PoliceStationData("06523278433", "09431706208"));
                break;

            //gumla end
            // hazaribagh start

            case "fire brigade":
                policeStationData.add(new PoliceStationData("N.A.", "7870083266"));
                break;
            case "daru ps":
                policeStationData.add(new PoliceStationData("n.a.", "7250812078"));
                break;
            case "mahila thana and st-sc thana":
                policeStationData.add(new PoliceStationData("n.a.", "9431706325"));
                break;
            case "tatijhariya ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470197389"));
                break;
            case "bishnugarh ps":
                policeStationData.add(new PoliceStationData("06548237842", "09431706312"));
                break;
            case "urimari op":
                policeStationData.add(new PoliceStationData("n.a.", "09973502171"));
                break;
            case "ichak ps":
                policeStationData.add(new PoliceStationData("06548285500", "09431706311"));
                break;
            case "churchu ps":
                policeStationData.add(new PoliceStationData("06546230025", "09431706303"));
                break;
            case "charhi ps":
                policeStationData.add(new PoliceStationData("06546232850", "09470197390"));
                break;
            case "giddi ps":
                policeStationData.add(new PoliceStationData("06553273188", "09431706321"));
                break;
            case "padma op":
                policeStationData.add(new PoliceStationData("06546238140", "09430741399"));
                break;
            case "chauparan ps":
                policeStationData.add(new PoliceStationData("06547276528", "09431706318"));
                break;
            case "gorhar ps":
                policeStationData.add(new PoliceStationData("n.a.", "09431706317"));
                break;
            case "barkatha ps":
                policeStationData.add(new PoliceStationData("06543268110", "09431706316"));
                break;
            case "barhi ps":
                policeStationData.add(new PoliceStationData("06546266238", "09431706315"));
                break;
            case "keredari ps":
                policeStationData.add(new PoliceStationData("06551281001", "09431706314"));
                break;
            case "barkagaon ps":
                policeStationData.add(new PoliceStationData("06551283642", "09431706313"));
                break;
            case "katkamsandi ps":
                policeStationData.add(new PoliceStationData("06546238763", "09431706310"));
                break;
            case "pelawal op":
                policeStationData.add(new PoliceStationData("06546264050", "09431396617"));
                break;
            case "sadar ps (hazaribagh)":
                policeStationData.add(new PoliceStationData("06546223033", "09431706308"));
                break;
            case "muffasil ps (hazaribagh)":
                policeStationData.add(new PoliceStationData("06546223090", "09431482100"));
                break;

            // hazaribagh end
            // jamtara start

            case "mahila ps-sc-st ps ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470591047"));
                break;
            case "karmatar ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470591048"));
                break;
            case "fatehpur ps":
                policeStationData.add(new PoliceStationData("06428288155", "09470591049"));
                break;
            case "bagdheri ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470591042"));
                break;
            case "bindapathar ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470591044"));
                break;
            case "mihijam ps":
                policeStationData.add(new PoliceStationData("06433228433", "09470591039"));
                break;
            case "nala ps":
                policeStationData.add(new PoliceStationData("06428228725", "09470591040"));
                break;
            case "kundhit ps":
                policeStationData.add(new PoliceStationData("06428238230", "09470591041"));
                break;
            case "narayanpur ps":
                policeStationData.add(new PoliceStationData("06433288240", "09470591045"));
                break;
            case "jamtara ps":
                policeStationData.add(new PoliceStationData("06433222233", "09470591038"));
                break;

            // jamtara end
            // khunti start

            case "tapakara op":
                policeStationData.add(new PoliceStationData("06538275375", "09431180414"));
                break;
            case "karra ps":
                policeStationData.add(new PoliceStationData("06538271149", "09431706200"));
                break;
            case "rania ps":
                policeStationData.add(new PoliceStationData("06538278011", "09431706199"));
                break;
            case "torpa ps":
                policeStationData.add(new PoliceStationData("06538233385", "09431706198"));
                break;
            case "arki ps":
                policeStationData.add(new PoliceStationData("06530256139", "09431706195"));
                break;
            case "khunti ps":
                policeStationData.add(new PoliceStationData("06528220528", "09431706196"));
                break;
            case "murhu ps":
                policeStationData.add(new PoliceStationData("06538274488", "09431706197"));
                break;

            // khunti end
            // koderma start

            case "koderma ps":
                policeStationData.add(new PoliceStationData("06534252228", "09431706352"));
                break;
            case "tilaiya ps":
                policeStationData.add(new PoliceStationData("06534222544", "09431706355"));
                break;
            case "tealiya dam op":
                policeStationData.add(new PoliceStationData("06534235100", "09431706355"));
                break;
            case "chandwara op":
                policeStationData.add(new PoliceStationData("06534233160", "09431166566"));
                break;
            case "domchanchi op":
                policeStationData.add(new PoliceStationData("06534255521", "09431166566"));
                break;
            case "jainagar ps":
                policeStationData.add(new PoliceStationData("06534263034", "09431706356"));
                break;
            case "satgawan ps":
                policeStationData.add(new PoliceStationData("06534263047", "09431706357"));
                break;
            case "markacho ps":
                policeStationData.add(new PoliceStationData("06534265751", "09431706358"));
                break;

            // koderma end
            // latehar start

            case "mahila ps (latehar)":
                policeStationData.add(new PoliceStationData("n.a.", "09431342985"));
                break;
            case "bareshandh":
                policeStationData.add(new PoliceStationData("n.a.", "09430738677"));
                break;
            case "chhipadohar":
                policeStationData.add(new PoliceStationData("n.a.", "8686783813"));
                break;
            case "herhanj ps":
                policeStationData.add(new PoliceStationData("n.a.", "09334106261"));
                break;
            case "manika ps":
                policeStationData.add(new PoliceStationData("06567241344", "07050631710"));
                break;
            case "latehar ps":
                policeStationData.add(new PoliceStationData("06565247642", "09431208252"));
                break;
            case "netarhat ps":
                policeStationData.add(new PoliceStationData("06569277663", "09431706280"));
                break;
            case "mmahuadand ps":
                policeStationData.add(new PoliceStationData("06569252353", "09431706279"));
                break;
            case "garu ps":
                policeStationData.add(new PoliceStationData("06569242211", "09431706278"));
                break;
            case "barwadih ps":
                policeStationData.add(new PoliceStationData("06567288228", "09431706277"));
                break;
            case "balumath ps":
                policeStationData.add(new PoliceStationData("06568266813", "09431706276"));
                break;
            case "chandwa ps":
                policeStationData.add(new PoliceStationData("06565226235", "09431706275"));
                break;

            // latehar end
            // lohardaga start

            case "st-sc-ahtu":
                policeStationData.add(new PoliceStationData("n.a.", "09431190055"));
                break;
            case "serendag":
                policeStationData.add(new PoliceStationData("n.a.", "09852307127"));
                break;
            case "bagru":
                policeStationData.add(new PoliceStationData("n.a.", "09771226310"));
                break;
            case "mahila ps (lohardaga)":
                policeStationData.add(new PoliceStationData("n.a.", "09431960788"));
                break;
            case "bhandra ps":
                policeStationData.add(new PoliceStationData("06526272240", "08987715565"));
                break;
            case "kairo ps":
                policeStationData.add(new PoliceStationData("n.a.", "09431091326"));
                break;
            case "kuru ps":
                policeStationData.add(new PoliceStationData("06526271242", "09431706221"));
                break;
            case "jowang ps":
                policeStationData.add(new PoliceStationData("n.a.", "09931548301"));
                break;
            case "kisko ps":
                policeStationData.add(new PoliceStationData("06526276214", "09431706223"));
                break;
            case "lohardaga ps":
                policeStationData.add(new PoliceStationData("06526224020", "09431706220"));
                break;
            case "senha ps":
                policeStationData.add(new PoliceStationData("06526275504", "09431706224"));
                break;

            // lohardaga end
            // pakur start

            case "sc-st ps":
                policeStationData.add(new PoliceStationData("n.a.", "09973702722"));
                break;
            case "malpahari op":
                policeStationData.add(new PoliceStationData("n.a.", "09973268328"));
                break;
            case "mahila ps (pakur)":
                policeStationData.add(new PoliceStationData("06435223420", "09546617789"));
                break;
            case "raddipur op":
                policeStationData.add(new PoliceStationData("06423228088", "08084821517"));
                break;
            case "pakuria ps":
                policeStationData.add(new PoliceStationData("06426250244", "09199652559"));
                break;
            case "littipara ps":
                policeStationData.add(new PoliceStationData("06435270050", "09523669095"));
                break;
            case "hiranpur ps":
                policeStationData.add(new PoliceStationData("06435268329", "09934095606"));
                break;
            case "town ps (pakur)":
                policeStationData.add(new PoliceStationData("06435222070", "09470591076"));
                break;
            case "pakur ps":
                policeStationData.add(new PoliceStationData("06435222070", "09431173715"));
                break;
            case "muffasil ps (pakur)":
                policeStationData.add(new PoliceStationData("06435220401", "09470591017"));
                break;
            case "amrapadha ps":
                policeStationData.add(new PoliceStationData("06423262667", "08521340831"));
                break;
            case "maheshpur ps":
                policeStationData.add(new PoliceStationData("06423228088", "08084995066"));
                break;

            // pakur end
            // palamu start

            case "town ps (palamu)":
                policeStationData.add(new PoliceStationData("06562222294", "09431706249"));
                break;
            case "sadar ps (palamu)":
                policeStationData.add(new PoliceStationData("06562240111", "09431706250"));
                break;
            case "padwa ps":
                policeStationData.add(new PoliceStationData("06560289696", "09431285582"));
                break;
            case "piprarand ps":
                policeStationData.add(new PoliceStationData("n.a.", "09162706322"));
                break;
            case "pandu ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470503973"));
                break;
            case "ramgarh ps (palamu)":
                policeStationData.add(new PoliceStationData("n.a.", "09431184872"));
                break;
            case "deori op":
                policeStationData.add(new PoliceStationData("06566222545", "09471147787"));
                break;
            case "satbarwa op":
                policeStationData.add(new PoliceStationData("06562254499", "09431706251"));
                break;
            case "terhashi ps":
                policeStationData.add(new PoliceStationData("06562290404", "09431362293"));
                break;
            case "manatu ps":
                policeStationData.add(new PoliceStationData("n.a.", "09431585746"));
                break;
            case "paton ps":
                policeStationData.add(new PoliceStationData("06560279497", "09431195378"));
                break;
            case "panki ps":
                policeStationData.add(new PoliceStationData("06562262370", "09431706261"));
                break;
            case "mohammadganj ps":
                policeStationData.add(new PoliceStationData("06566242291", "09431164149"));
                break;
            case "haidernagar ps":
                policeStationData.add(new PoliceStationData("06566232459", "09431706257"));
                break;
            case "hussainbad ps":
                policeStationData.add(new PoliceStationData("06566222237", "09431706256"));
                break;
            case "chattarpur ps":
                policeStationData.add(new PoliceStationData("06566285236", "09431706259"));
                break;
            case "hariharganj ps":
                policeStationData.add(new PoliceStationData("06566251610", "09431706260"));
                break;
            case "rehla ps":
                policeStationData.add(new PoliceStationData("06584262233", "09431706255"));
                break;
            case "nawdiha ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470969651"));
                break;
            case "bisrampur ps":
                policeStationData.add(new PoliceStationData("06584262278", "09431706254"));
                break;
            case "chainpur ps (palamu)":
                policeStationData.add(new PoliceStationData("06586251151", "09431706252"));
                break;
            case "lesliganj ps":
                policeStationData.add(new PoliceStationData("06562282619", "09431706253"));
                break;

            // palamu end
            // ramgarh start

            case "bhadani nagar op":
                policeStationData.add(new PoliceStationData("n.a.", "09431139428"));
                break;
            case "west bokaro op":
                policeStationData.add(new PoliceStationData("06545243881", "09470172872"));
                break;
            case "bhurkunda ps":
                policeStationData.add(new PoliceStationData("06546249700", "09431706323"));
                break;
            case "kujju op":
                policeStationData.add(new PoliceStationData("06545281266", "09431192296"));
                break;
            case "mandu ps":
                policeStationData.add(new PoliceStationData("06545264166", "09431706324"));
                break;
            case "rajrappa ps":
                policeStationData.add(new PoliceStationData("06553251977", "09931344824"));
                break;
            case "basal ps":
                policeStationData.add(new PoliceStationData("06553275577", "09934307206"));
                break;
            case "barkakana op":
                policeStationData.add(new PoliceStationData("06553254858", "09955454601"));
                break;
            case "ramgarh ps":
                policeStationData.add(new PoliceStationData("06553222012", "09431706319"));
                break;
            case "patratu ps":
                policeStationData.add(new PoliceStationData("06553286540", "09431706322"));
                break;
            case "gola ps":
                policeStationData.add(new PoliceStationData("06553274207", "09431706320"));
                break;

            // ramgarh end
            // ranchi start

            case "tupudana op":
                policeStationData.add(new PoliceStationData("06512291903", "09431706167"));
                break;
            case "tamar ps":
                policeStationData.add(new PoliceStationData("06530252472", "09431706193"));
                break;
            case "pandra op":
                policeStationData.add(new PoliceStationData("06512510002", "09431706878"));
                break;
            case "mackluskiganj ps":
                policeStationData.add(new PoliceStationData("n.a.", "09608316771"));
                break;
            case "gonda ps":
                policeStationData.add(new PoliceStationData("06512281266", "09431706162"));
                break;
            case "pundag ps":
                policeStationData.add(new PoliceStationData("n.a.", "09431706913"));
                break;
            case "bit mesra ps":
                policeStationData.add(new PoliceStationData("n.a.", "09955911474"));
                break;
            case "rahe op":
                policeStationData.add(new PoliceStationData("06530271077", "09431706194"));
                break;
            case "muri op":
                policeStationData.add(new PoliceStationData("06522290277", "08051206731"));
                break;
            case "narkopi ps":
                policeStationData.add(new PoliceStationData("n.a.", "099343133677"));
                break;
            case "nagri ps":
                policeStationData.add(new PoliceStationData("06512775702", "09431706176"));
                break;
            case "mahila ps (ranchi)":
                policeStationData.add(new PoliceStationData("06512210533", "08102302402"));
                break;
            case "burmu ps":
                policeStationData.add(new PoliceStationData("06531274110", "09431706190"));
                break;
            case "sc-st ps (ranchi)":
                policeStationData.add(new PoliceStationData("06512217993", "0941103958"));
                break;
            case "traffic ps (ranchi)":
                policeStationData.add(new PoliceStationData("06512317774", "09431706172"));
                break;
            case "tatisilway ps":
                policeStationData.add(new PoliceStationData("06512265789", "09431706174"));
                break;
            case "silli ps":
                policeStationData.add(new PoliceStationData("06522222700", "09431164807"));
                break;
            case "sikidiri ps":
                policeStationData.add(new PoliceStationData("06530252472", "09431706184"));
                break;
            case "sadar ps (ranchi)":
                policeStationData.add(new PoliceStationData("06512544625", "09431706160"));
                break;
            case "angara ps":
                policeStationData.add(new PoliceStationData("06522272024", "09431706180"));
                break;
            case "mandar ps":
                policeStationData.add(new PoliceStationData("06531224581", "09431706187"));
                break;
            case "lapung ps":
                policeStationData.add(new PoliceStationData("06529271010", "09431706178"));
                break;
            case "lalpur ps":
                policeStationData.add(new PoliceStationData("06512203754", "09431706159"));
                break;
            case "kotwali ps":
                policeStationData.add(new PoliceStationData("06512200968", "09431706158"));
                break;
            case "kanke ps":
                policeStationData.add(new PoliceStationData("06512230734", "09431706185"));
                break;
            case "etki ps":
                policeStationData.add(new PoliceStationData("06529227243", "09431706177"));
                break;
            case "dhurwa ps":
                policeStationData.add(new PoliceStationData("06512408299", "09431706166"));
                break;
            case "daily market ps":
                policeStationData.add(new PoliceStationData("06512308685", "09431706163"));
                break;
            case "chanho ps":
                policeStationData.add(new PoliceStationData("06531274362", "09431706189"));
                break;
            case "bundu ps":
                policeStationData.add(new PoliceStationData("06530222251", "09431706191"));
                break;
            case "argora ps":
                policeStationData.add(new PoliceStationData("06512242132", "09431706170"));
                break;
            case "khelari ps":
                policeStationData.add(new PoliceStationData("06531246410", "09431706188"));
                break;
            case "bero ps":
                policeStationData.add(new PoliceStationData("06529277376", "09431706179"));
                break;
            case "pithoria ps":
                policeStationData.add(new PoliceStationData("06512475432", "09431706186"));
                break;
            case "ratu ps":
                policeStationData.add(new PoliceStationData("06512521424", "09431706175"));
                break;
            case "sonahatu ps":
                policeStationData.add(new PoliceStationData("06530274043", "09431706192"));
                break;
            case "oramanjhi ps":
                policeStationData.add(new PoliceStationData("06512576523", "09431706183"));
                break;
            case "namkum ps":
                policeStationData.add(new PoliceStationData("06512261900", "09431706173"));
                break;
            case "jagnnathpur ps":
                policeStationData.add(new PoliceStationData("06512442692", "09431706169"));
                break;
            case "hindipiri ps":
                policeStationData.add(new PoliceStationData("06512205409", "09431706164"));
                break;
            case "chutia ps":
                policeStationData.add(new PoliceStationData("06512461880", "09431706165"));
                break;
            case "lower bazar ps":
                policeStationData.add(new PoliceStationData("06512351002", "09431706171"));
                break;
            case "bariyatu ps":
                policeStationData.add(new PoliceStationData("06512542660", "09431706161"));
                break;
            case "sukhdeo nagar ps":
                policeStationData.add(new PoliceStationData("06512284509", "08521605643"));
                break;
            case "doranda ps":
                policeStationData.add(new PoliceStationData("06512481057", "09431706168"));
                break;

            // racnhi end
            // sahibganj start

            case "zirwabari op":
                policeStationData.add(new PoliceStationData("06436223788", "09470591087"));
                break;
            case "barhet ps":
                policeStationData.add(new PoliceStationData("06426268820", "09470591090"));
                break;
            case "borio ps":
                policeStationData.add(new PoliceStationData("06436252002", "09470591089"));
                break;
            case "muffasil ps (sahibganj)":
                policeStationData.add(new PoliceStationData("06436223557", "09470591086"));
                break;
            case "town ps (sahibganj)":
                policeStationData.add(new PoliceStationData("06436222002", "09470591084"));
                break;
            case "kotalpokhar ps":
                policeStationData.add(new PoliceStationData("06435242031", "09470591098"));
                break;
            case "ranga ps":
                policeStationData.add(new PoliceStationData("06426278748", "09470591099"));
                break;
            case "barharwa ps":
                policeStationData.add(new PoliceStationData("n.a.", "09470591097"));
                break;
            case "radhanagar ps":
                policeStationData.add(new PoliceStationData("06426276439", "09470591096"));
                break;
            case "taljhari ps (sahibganj)":
                policeStationData.add(new PoliceStationData("06426246313", "09470591094"));
                break;
            case "raj mahal ps":
                policeStationData.add(new PoliceStationData("06426228130", "09470591095"));
                break;
            case "mirzachowki ps":
                policeStationData.add(new PoliceStationData("06436244268", "09470591093"));
                break;

            // sahibganj end
            // saraikela start

            case "kapali op":
                policeStationData.add(new PoliceStationData("n.a.", "09431117980"));
                break;
            case "adityapur ps":
                policeStationData.add(new PoliceStationData("06572372666", "09431706535"));
                break;
            case "tiruldih op":
                policeStationData.add(new PoliceStationData("n.a.", "09955715162"));
                break;
            case "humid op":
                policeStationData.add(new PoliceStationData("06591232025", "06591232428"));
                break;
            case "amda op":
                policeStationData.add(new PoliceStationData("06583252798", "06583252798"));
                break;
            case "r.i.t. ps":
                policeStationData.add(new PoliceStationData("06572370001", "09431706542"));
                break;
            case "saraikela ps":
                policeStationData.add(new PoliceStationData("06597234646", "08757888805"));
                break;
            case "nimdih ps":
                policeStationData.add(new PoliceStationData("06591233339", "09431706545"));
                break;
            case "ichagarh ps":
                policeStationData.add(new PoliceStationData("06591283438", "09431706546"));
                break;
            case "chowka ps":
                policeStationData.add(new PoliceStationData("n.a.", "09973763515"));
                break;
            case "chandil ps":
                policeStationData.add(new PoliceStationData("06591236531", "09431706544"));
                break;
            case "kandra op":
                policeStationData.add(new PoliceStationData("06597255380", "09431706547"));
                break;
            case "gamharia ps":
                policeStationData.add(new PoliceStationData("06572386500", "09431706541"));
                break;
            case "dalbhanga op":
                policeStationData.add(new PoliceStationData("n.a.", "09798423588"));
                break;
            case "kuchai ps":
                policeStationData.add(new PoliceStationData("06583253206", "065832892400"));
                break;
            case "kharsawan ps":
                policeStationData.add(new PoliceStationData("06583254947", "09431706538"));
                break;
            case "raj nagar ps":
                policeStationData.add(new PoliceStationData("06597252275", "09431706540"));
                break;

            // saraikela end
            // simdega start

            case "bano ps":
                policeStationData.add(new PoliceStationData("06527275723", "09431706236"));
                break;
            case "kersai ps":
                policeStationData.add(new PoliceStationData("n.a.", "09801511346"));
                break;
            case "mahila ps (simdega)":
                policeStationData.add(new PoliceStationData("n.a.", "08102124019"));
                break;
            case "sc-st ps (simdega)":
                policeStationData.add(new PoliceStationData("n.a.", "09939642074"));
                break;
            case "kolebira ps":
                policeStationData.add(new PoliceStationData("06527265511", "09431706235"));
                break;
            case "bolwa ps":
                policeStationData.add(new PoliceStationData("06539266219", "09431706234"));
                break;
            case "simdega ps":
                policeStationData.add(new PoliceStationData("06525226251", "09431706231"));
                break;
            case "thetaitangar ps":
                policeStationData.add(new PoliceStationData("06525273147", "09431706232"));
                break;
            case "orga op":
                policeStationData.add(new PoliceStationData("n.a.", "09431338193"));
                break;
            case "kurdeg ps":
                policeStationData.add(new PoliceStationData("06525255254", "09431706233"));
                break;
            case "jaldega ps":
                policeStationData.add(new PoliceStationData("06527277227", "09431706237"));
                break;
            case "girda op":
                policeStationData.add(new PoliceStationData("n.a.", "09955105027"));
                break;
            case "bansjhor op":
                policeStationData.add(new PoliceStationData("n.a.", "09431398582"));
                break;

            // simdega end
            // west singhbhum start

            case "ckp top-3":
                policeStationData.add(new PoliceStationData("06587236634", "09430755506"));
                break;
            case "ckp top-2":
                policeStationData.add(new PoliceStationData("06587236589", "09431933604"));
                break;
            case "ckp top-1":
                policeStationData.add(new PoliceStationData("06587236612", "09576656308"));
                break;
            case "sadar top":
                policeStationData.add(new PoliceStationData("06582259600", "09631087677"));
                break;
            case "jetya":
                policeStationData.add(new PoliceStationData("n.a.", "08804667595"));
                break;
            case "tebo ps":
                policeStationData.add(new PoliceStationData("n.a.", "09955008098"));
                break;
            case "jaraikella ps":
                policeStationData.add(new PoliceStationData("06593287744", "09431949171"));
                break;
            case "jamda op":
                policeStationData.add(new PoliceStationData("06596262254", "09471509440"));
                break;
            case "chhotanagra ps":
                policeStationData.add(new PoliceStationData("n.a.", "09431394254"));
                break;
            case "nowamundi ps":
                policeStationData.add(new PoliceStationData("06596233300", "09431706473"));
                break;
            case "kiriburu ps":
                policeStationData.add(new PoliceStationData("06596244986", "09431706471"));
                break;
            case "muffasil ps (west singhbhum)":
                policeStationData.add(new PoliceStationData("06582256842", "09431706463"));
                break;
            case "sadar ps (west singhbhum)":
                policeStationData.add(new PoliceStationData("06582256841", "09431706462"));
                break;
            case "chiriya op":
                policeStationData.add(new PoliceStationData("06593287745", "09431167928"));
                break;
            case "tatanagar op":
                policeStationData.add(new PoliceStationData("06589285405", "09430506738"));
                break;
            case "chakradharpur ps":
                policeStationData.add(new PoliceStationData("06587238027", "09431706465"));
                break;
            case "pandrashali op":
                policeStationData.add(new PoliceStationData("06582282233", "09835785748"));
                break;
            case "jhinkpani ps":
                policeStationData.add(new PoliceStationData("06589235606", "09431706475"));
                break;
            case "manjhari ps":
                policeStationData.add(new PoliceStationData("06589285334", "09431706464"));
                break;
            case "hatgamharia ps":
                policeStationData.add(new PoliceStationData("06589233378", "09431706479"));
                break;
            case "majhgaon ps":
                policeStationData.add(new PoliceStationData("06588244055", "09431151834"));
                break;
            case "kumardungi ps":
                policeStationData.add(new PoliceStationData("0658826661", "08084761004"));
                break;
            case "jaganathpur ps":
                policeStationData.add(new PoliceStationData("06588252699", "09431706474"));
                break;
            case "toklo ps":
                policeStationData.add(new PoliceStationData("06587288308", "09431066741"));
                break;
            case "tonto ps":
                policeStationData.add(new PoliceStationData("06589235616", "09431706476"));
                break;
            case "goilkera ps":
                policeStationData.add(new PoliceStationData("06587224206", "09431706470"));
                break;
            case "gua ps":
                policeStationData.add(new PoliceStationData("06596263860", "09431706472"));
                break;
            case "sonua ps":
                policeStationData.add(new PoliceStationData("06587277210", "09431706468"));
                break;
            case "karaikela ps":
                policeStationData.add(new PoliceStationData("06587244266", "09431706466"));
                break;
            case "bandgaon ps":
                policeStationData.add(new PoliceStationData("06587255216", "09431706467"));
                break;
            case "manoharpur ps":
                policeStationData.add(new PoliceStationData("06593232513", "09431706469"));
                break;

            // west singhbhum end

        }

        // loading the listview
        PoliceStationDataAdapter dataAdapter = new PoliceStationDataAdapter(PoliceStationDetailsActivity.this, policeStationData);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(dataAdapter);

        View v = dataAdapter.getView(0, null, listView);

        //Toast.makeText(PoliceStationDetailsActivity.this,phoneText.getText(),Toast.LENGTH_SHORT).show();
            phoneText = (TextView) v.findViewById(R.id.station_phone_number_textview);
            mobileText = (TextView) v.findViewById(R.id.station_mobile_number_textview);
            //Log.d ("Text", tx.getText().toString());

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_TEXT, "Contact Details:\n Police Station : " + policeStation + "\nPhone No : " + phoneText.getText().toString() + "\nMobile No : " + mobileText.getText().toString() + "\nDownload the app now\nhttps://play.google.com/store/apps/details?id=com.kiusoftech.dialacop_jharpolice");
                intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "Contact Sharing");
                startActivity(Intent.createChooser(intent, "Share Contact"));
            }
        });

        makeFavoriteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                makePoliceStationFav();
            }
        });


    }

    private List<FavoriteEntity> checkFavoriteTable;
    private void makeFavoriteButtonVisibility() {

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

                checkFavoriteTable = DialACopDatabase.getAppDatabase(getApplicationContext()).favoriteEntityDao().checkInFavoriteEntity(policeStation);

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

    private void makePoliceStationFav() {

        new AsyncTask<Void, Void, Void>(){

            @Override
            protected Void doInBackground(Void... voids) {

                FavoriteEntity favorites = new FavoriteEntity();

                favorites.setFavoriteItemTitle(policeStation);
                favorites.setIdentifier(1);

                long[] insertedStations = DialACopDatabase.getAppDatabase(getApplicationContext()).favoriteEntityDao().insertFavoriteEntity(favorites);

                Log.d(TAG,"inserted stations : "+insertedStations.length);

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                makeFavoriteButton.setVisibility(View.GONE);
                Toast.makeText(PoliceStationDetailsActivity.this, policeStation.toUpperCase() + " Added to Favorites.", Toast.LENGTH_SHORT).show();
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
                Intent i = new Intent(PoliceStationDetailsActivity.this,AboutActivity.class);
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

