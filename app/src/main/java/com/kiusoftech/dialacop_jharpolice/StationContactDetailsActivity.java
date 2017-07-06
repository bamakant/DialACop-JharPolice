package com.kiusoftech.dialacop_jharpolice;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.WindowDecorActionBar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class StationContactDetailsActivity extends AppCompatActivity {

    String policeStation;
    TextView policeStationtextView;
    ArrayList<StationContactData> stationContactDatas;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_layout);

        policeStation = getIntent().getExtras().getString("PoliceStationName");

        policeStationtextView = (TextView) findViewById(R.id.police_station_textview);

        policeStationtextView.setText(policeStation);

        stationContactDatas = new ArrayList<>();

        //@ load data according to station name passed by intent.

        switch (policeStation) {

            case "oc sc-st":
                stationContactDatas.add(new StationContactData("N.A.", "09835714053"));
                break;
            case "oc penk narayanpur":
                stationContactDatas.add(new StationContactData("N.A.", "09102307266"));
                break;
            case "oc jageswar vihar":
                stationContactDatas.add(new StationContactData("N.A.", "07654748056"));
                break;
            case "oc chattrochati":
                stationContactDatas.add(new StationContactData("N.A.", "07764957761"));
                break;
            case "balidih biyada op":
                stationContactDatas.add(new StationContactData("N.A.", "09534236926"));
                break;
            case "b.t.p.s. ps":
                stationContactDatas.add(new StationContactData("06549266100", "09431706443"));
                break;
            case "gandhinagar ps":
                stationContactDatas.add(new StationContactData("06549260002", "09939312034"));
                break;
            case "mahuatand ps":
                stationContactDatas.add(new StationContactData("06544253129", "07762932916"));
                break;
            case "tenughat op":
                stationContactDatas.add(new StationContactData("06549230401", "09431706437"));
                break;
            case "mahila ps":
                stationContactDatas.add(new StationContactData("06542220016", "09798150624"));
                break;
            case "bhojudih ps":
                stationContactDatas.add(new StationContactData("N.A.", "09199613206"));
                break;
            case "sector-6 ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706429"));
                break;
            case "bokaro jharia op":
                stationContactDatas.add(new StationContactData("N.A.", "08271766263"));
                break;
            case "bermo ps":
                stationContactDatas.add(new StationContactData("06549220202", "09431706436"));
                break;
            case "petarwar ps":
                stationContactDatas.add(new StationContactData("06549265699", "09431706448"));
                break;
            case "amlabad op":
                stationContactDatas.add(new StationContactData("N.A.", "09263638478"));
                break;
            case "bangaria op":
                stationContactDatas.add(new StationContactData("N.A.", "08651037838"));
                break;
            case "barmasia op":
                stationContactDatas.add(new StationContactData("N.A.", "09507308355"));
                break;
            case "b.s. city ps":
                stationContactDatas.add(new StationContactData("06542247832", "09431706424"));
                break;
            case "chas ps":
                stationContactDatas.add(new StationContactData("06542265940", "09431706434"));
                break;
            case "siyaljory ps":
                stationContactDatas.add(new StationContactData("N.A.", "08651102618"));
                break;
            case "sector-12 ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706431"));
                break;
            case "marafari ps":
                stationContactDatas.add(new StationContactData("06542247855", "09431706432"));
                break;
            case "i.e.l. ps":
                stationContactDatas.add(new StationContactData("06544262329", "09431706446"));
                break;
            case "nawadih ps":
                stationContactDatas.add(new StationContactData("06549233066", "09973000638"));
                break;
            case "pindrajora ps":
                stationContactDatas.add(new StationContactData("N.A.", "09934715842"));
                break;
            case "sector-4 ps":
                stationContactDatas.add(new StationContactData("06542233100", "09431706428"));
                break;
            case "harla ps":
                stationContactDatas.add(new StationContactData("06542262170", "9431706430"));
                break;
            case "chas (m) ps":
                stationContactDatas.add(new StationContactData("N.A.", "09199303541"));
                break;
            case "chandankiyari ps":
                stationContactDatas.add(new StationContactData("06542230768", "9939356551"));
                break;
            case "gomia ps":
                stationContactDatas.add(new StationContactData("06544261262", "09431706445"));
                break;
            case "lalpania op":
                stationContactDatas.add(new StationContactData("06544225418", "09199434695"));
                break;
            case "jaridih ps":
                stationContactDatas.add(new StationContactData("06542250020","09431706449"));
                break;
            case "kasmar ps":
                stationContactDatas.add(new StationContactData("06542263307", "09431706450"));
                break;
            case "kathara op":
                stationContactDatas.add(new StationContactData("N.A.", "0919943469"));
                break;
            case "balidih ps":
                stationContactDatas.add(new StationContactData("06542253754", "09431706433"));
                break;
            case "dugdha ps":
                stationContactDatas.add(new StationContactData("06549244099", "09431706442"));
                break;
            case "chandrapura ps":
                stationContactDatas.add(new StationContactData("06549242230", "09431706441"));
                break;
            case "sadar ps":
                stationContactDatas.add(new StationContactData("06541222233", "09431706364"));
                break;
            case "simariya ps":
                stationContactDatas.add(new StationContactData("06559233315", "09431706367"));
                break;
            case "lawalong ps":
                stationContactDatas.add(new StationContactData("N.A.", "07277485621"));
                break;
            case "rajpur ps":
                stationContactDatas.add(new StationContactData("N.A.", "09955313568"));
                break;
            case "gidhaur ps":
                stationContactDatas.add(new StationContactData("N.A.", "09934382031"));
                break;
            case "piparwar ps":
                stationContactDatas.add(new StationContactData("06531260233", "09431706368"));
                break;
            case "tandwa ps":
                stationContactDatas.add(new StationContactData("06559244440", "07762955427"));
                break;
            case "pratappur ps":
                stationContactDatas.add(new StationContactData("06550265501", "09631340500"));
                break;
            case "pathalgadda ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431321460"));
                break;
            case "kunda ps":
                stationContactDatas.add(new StationContactData("N.A.", "0939904770"));
                break;
            case "itkhori ps":
                stationContactDatas.add(new StationContactData("06541266233", "09431706366"));
                break;
            case "hunterganj ps":
                stationContactDatas.add(new StationContactData("06550255240", "09162752962"));
                break;
            case "bashishtnagar ps (jori)":
                stationContactDatas.add(new StationContactData("06549242230", "09431706441"));
                break;

            // chatra end
            //deoghar start

            case "margomunda ps":
                stationContactDatas.add(new StationContactData("N.A.", "09934571284"));
                break;
            case "devipur ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431137631"));
                break;
            case "babamandir ps":
                stationContactDatas.add(new StationContactData("06432232600", "09431137941"));
                break;
            case "mahila ps (deoghar)":
                stationContactDatas.add(new StationContactData("06432232600", "09835751602"));
                break;
            case "chitra ps":
                stationContactDatas.add(new StationContactData("06438264239", "09470591060"));
                break;
            case "palajori ps":
                stationContactDatas.add(new StationContactData("06438274640", "09470591059"));
                break;
            case "sarth ps":
                stationContactDatas.add(new StationContactData("06438254194", "09470591058"));
                break;
            case "karoon ps":
                stationContactDatas.add(new StationContactData("06438256861", "09470591057"));
                break;
            case "madhupur ps":
                stationContactDatas.add(new StationContactData("06438224427", "09470591056"));
                break;
            case "sonaraydhari ps":
                stationContactDatas.add(new StationContactData("06432257307", "09470591055"));
                break;
            case "sarwa ps":
                stationContactDatas.add(new StationContactData("06432288110", "09470591054"));
                break;
            case "mohanpur ps":
                stationContactDatas.add(new StationContactData("06432281024", "09470591053"));
                break;
            case "town ps (deoghar)":
                stationContactDatas.add(new StationContactData("06432232600", "09470591050"));
                break;
            case "kunda ps (deoghar)":
                stationContactDatas.add(new StationContactData("06432225430", "09470591051"));
                break;
            case "jasidih ps":
                stationContactDatas.add(new StationContactData("06432270234", "09470591052"));
                break;
            //deoghar end
            //dhanbad start

            case "ghanuadih op":
                stationContactDatas.add(new StationContactData("N.A.", "07870788674"));
                break;
            case "gonudih op":
                stationContactDatas.add(new StationContactData("N.A.", "08936000043"));
                break;
            case "kharkhari op":
                stationContactDatas.add(new StationContactData("N.A.", "09431915330"));
                break;
            case "bhatdih op":
                stationContactDatas.add(new StationContactData("N.A.", "09234445101"));
                break;
            case "traffic ps":
                stationContactDatas.add(new StationContactData("N.A.", "07739224286"));
                break;
            case "borragarh op":
                stationContactDatas.add(new StationContactData("N.A.", "09955913502"));
                break;
            case "angar pathira op":
                stationContactDatas.add(new StationContactData("N.A.", "09430309815"));
                break;
            case "east basuriya op":
                stationContactDatas.add(new StationContactData("N.A.", "08578879315"));
                break;
            case "purbi tundi ps":
                stationContactDatas.add(new StationContactData("N.A.", "07352374918"));
                break;
            case "maniyadih ps":
                stationContactDatas.add(new StationContactData("N.A.", "09102478794"));
                break;
            case "chirkunda ps":
                stationContactDatas.add(new StationContactData("06540272224", "09431706403"));
                break;
            case "dhanuadih op":
                stationContactDatas.add(new StationContactData("03262361166", "09470967570"));
                break;
            case "lodna op":
                stationContactDatas.add(new StationContactData("03263200005", "09931657545"));
                break;
            case "munidih op":
                stationContactDatas.add(new StationContactData("03262339096", "08298094676"));
                break;
            case "bhagabandh op":
                stationContactDatas.add(new StationContactData("03260339066", "09939576629"));
                break;
            case "goushala op":
                stationContactDatas.add(new StationContactData("03262350545", "08102402922"));
                break;
            case "bhuli op":
                stationContactDatas.add(new StationContactData("03262340262", "09431372663"));
                break;
            case "maithan op":
                stationContactDatas.add(new StationContactData("06540274888", "09431275415"));
                break;
            case "pancheat op":
                stationContactDatas.add(new StationContactData("06540286345", "09934385912"));
                break;
            case "galfarbari op":
                stationContactDatas.add(new StationContactData("06540272748", "09431147153"));
                break;
            case "dharmabandh op":
                stationContactDatas.add(new StationContactData("03262251100", "09470584577"));
                break;
            case "ramkanali op":
                stationContactDatas.add(new StationContactData("03262384284", "09931346689"));
                break;
            case "sonardih op":
                stationContactDatas.add(new StationContactData("03262374399", "07250501453"));
                break;
            case "tisra ps":
                stationContactDatas.add(new StationContactData("03262290100", "09431285582"));
                break;
            case "mahuda ps":
                stationContactDatas.add(new StationContactData("03242221100", "09431706411"));
                break;
            case "madhuban ps":
                stationContactDatas.add(new StationContactData("03262392085", "09431706412"));
                break;
            case "kenduadih ps":
                stationContactDatas.add(new StationContactData("03262330343", "09431706394"));
                break;
            case "bankmore ps":
                stationContactDatas.add(new StationContactData("03262302417", "09431706392"));
                break;
            case "bhonra op":
                stationContactDatas.add(new StationContactData("03262320076", "03262320077"));
                break;
            case "saraidhela ps":
                stationContactDatas.add(new StationContactData("03262201030", "09431706398"));
                break;
            case "jogta ps":
                stationContactDatas.add(new StationContactData("03262372540", "09431706396"));
                break;
            case "loyabod ps":
                stationContactDatas.add(new StationContactData("03262330778", "09431706397"));
                break;
            case "putki ps":
                stationContactDatas.add(new StationContactData("03262330434", "09431706395"));
                break;
            case "dhansar ps":
                stationContactDatas.add(new StationContactData("03262307538", "09431706393"));
                break;
            case "kumardhubi op":
                stationContactDatas.add(new StationContactData("06540272750", "09431706393"));
                break;
            case "nirsa ps":
                stationContactDatas.add(new StationContactData("06540275042", "09431406417"));
                break;
            case "patherdih ps":
                stationContactDatas.add(new StationContactData("03262381707", "09431706417"));
                break;
            case "sudamdih ps":
                stationContactDatas.add(new StationContactData("03262380380", "09431706416"));
                break;
            case "alakhadiha op":
                stationContactDatas.add(new StationContactData("03262361259", "09431706416"));
                break;
            case "jorapokhar ps":
                stationContactDatas.add(new StationContactData("03262381401", "09431706415"));
                break;
            case "baliapur ps":
                stationContactDatas.add(new StationContactData("03262431244", "09431706414"));
                break;
            case "sindri ps":
                stationContactDatas.add(new StationContactData("03262350512", "09431706413"));
                break;
            case "tetulmari ps":
                stationContactDatas.add(new StationContactData("03262374379", "09431706409"));
                break;
            case "barora ps":
                stationContactDatas.add(new StationContactData("03262392185", "09431706410"));
                break;
            case "rajganj op":
                stationContactDatas.add(new StationContactData("03262272320", "09431706408"));
                break;
            case "katras ps":
                stationContactDatas.add(new StationContactData("03262372440", "09431706407"));
                break;
            case "baghmara ps":
                stationContactDatas.add(new StationContactData("03262428376", "09431706404"));
                break;
            case "hariharpur ps":
                stationContactDatas.add(new StationContactData("03262472715", "09431706406"));
                break;
            case "topchanchi ps":
                stationContactDatas.add(new StationContactData("03262482202", "09431706405"));
                break;
            case "barwadda ps":
                stationContactDatas.add(new StationContactData("03262207679", "09431706401"));
                break;
            case "tundi ps":
                stationContactDatas.add(new StationContactData("06540282175", "09431706400"));
                break;
            case "govindpur ps":
                stationContactDatas.add(new StationContactData("06540262255", "09431706415"));
                break;
            //dhanbad end
            // dumka start

            case "muffassil ps":
                stationContactDatas.add(new StationContactData("06434222313", "09470591021"));
                break;
            case "shikaripara ps":
                stationContactDatas.add(new StationContactData("06427268872", "09470591009"));
                break;
            case "town ps":
                stationContactDatas.add(new StationContactData("06434222234", "09470591008"));
                break;
            case "gopikandar ps":
                stationContactDatas.add(new StationContactData("06427251011", "09470591020"));
                break;
            case "kathikund ps":
                stationContactDatas.add(new StationContactData("0642722079", "09470591019"));
                break;
            case "saraiya hat ps":
                stationContactDatas.add(new StationContactData("06431260957", "09470591016"));
                break;
            case "jama ps":
                stationContactDatas.add(new StationContactData("06431258820", "09470591014"));
                break;
            case "raneshwar ps":
                stationContactDatas.add(new StationContactData("06434268605", "09470591010"));
                break;
            case "masliya ps":
                stationContactDatas.add(new StationContactData("06434255002", "09470591011"));
                break;
            case "tongra ps":
                stationContactDatas.add(new StationContactData("06434290123", "09470591012"));
                break;
            case "jarmundih ps":
                stationContactDatas.add(new StationContactData("06431230631", "09470591013"));
                break;
            case "ramgarh ps (dumka)":
                stationContactDatas.add(new StationContactData("06431270050", "09470591018"));
                break;
            case "hansdiha ps":
                stationContactDatas.add(new StationContactData("06431248244", "09470591017"));
                break;
            case "taljhari ps":
                stationContactDatas.add(new StationContactData("06431250022", "09470591015"));
                break;
            case "masanjor op":
                stationContactDatas.add(new StationContactData("06434269033", "09470591022"));
                break;

            //dumka end
            // east singhbhum start

            case "galudih":
                stationContactDatas.add(new StationContactData("N.A.", "09431534577"));
                break;
            case "mango ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706488"));
                break;
            case "sonari ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706507"));
                break;
            case "burmamines ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706513"));
                break;
            case "kadma ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706506"));
                break;
            case "parsudih ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706515"));
                break;
            case "sspur":
                stationContactDatas.add(new StationContactData("N.A.", "09431706521"));
                break;
            case "sundarnagar ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706516"));
                break;
            case "birsanagar ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706512"));
                break;
            case "govindpur ps (jsr)":
                stationContactDatas.add(new StationContactData("N.A.", "09431706511"));
                break;
            case "boram":
                stationContactDatas.add(new StationContactData("N.A.", "09386316294"));
                break;
            case "azadnagar ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706502"));
                break;
            case "telco":
                stationContactDatas.add(new StationContactData("N.A.", "09431706510"));
                break;
            case "jugsalai ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706495"));
                break;
            case "sidhgora ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706508"));
                break;
            case "sitaramdera ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706509"));
                break;
            case "golmuri ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706494"));
                break;
            case "olidih op":
                stationContactDatas.add(new StationContactData("N.A.", "09431706501"));
                break;
            case "moubhandar op":
                stationContactDatas.add(new StationContactData("N.A.", "09431706518"));
                break;
            case "dhalbhumgarh ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706519"));
                break;
            case "bahragora ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706526"));
                break;
            case "bagbera":
                stationContactDatas.add(new StationContactData("N.A.", "09431706514"));
                break;
            case "ghatsila ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706517"));
                break;
            case "dumaria ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706524"));
                break;
            case "potka ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706525"));
                break;
            case "gurubanda ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706528"));
                break;
            case "jadugora ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706523"));
                break;
            case "chakulia":
                stationContactDatas.add(new StationContactData("N.A.", "09431706520"));
                break;
            case "kamalpur":
                stationContactDatas.add(new StationContactData("N.A.", "09431706505"));
                break;
            case "musabani":
                stationContactDatas.add(new StationContactData("N.A.", "09431706522"));
                break;
            case "patamda ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706504"));
                break;
            case "barsol ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706527"));
                break;
            case "mgm ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706503"));
                break;
            case "sakchi ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706491"));
                break;
            case "bistupur ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706497"));
                break;

            // east singhbhum end
            // garhwa start

            case "mahila thana":
                stationContactDatas.add(new StationContactData("N.A.", "09431511570"));
                break;
            case "bardiha":
                stationContactDatas.add(new StationContactData("N.A.", "09835771617"));
                break;
            case "bishunpura":
                stationContactDatas.add(new StationContactData("N.A.", "07677848473"));
                break;
            case "ketar":
                stationContactDatas.add(new StationContactData("N.A.", "08434497121"));
                break;
            case "danda":
                stationContactDatas.add(new StationContactData("N.A.", "08292311784"));
                break;
            case "bhandaria ps":
                stationContactDatas.add(new StationContactData("06581255546", "09431570183"));
                break;
            case "nagar untari ps":
                stationContactDatas.add(new StationContactData("06564252413", "09709071914"));
                break;
            case "hariharpur op":
                stationContactDatas.add(new StationContactData("N.A.", "09939046270"));
                break;
            case "kharondi ps":
                stationContactDatas.add(new StationContactData("N.A.", "09934336920"));
                break;
            case "ramna ps":
                stationContactDatas.add(new StationContactData("N.A.", "08541824127"));
                break;
            case "dandai ps":
                stationContactDatas.add(new StationContactData("N.A.", "09955960566"));
                break;
            case "ramkanda ps":
                stationContactDatas.add(new StationContactData("N.A.", "09835771617"));
                break;
            case "chinia ps":
                stationContactDatas.add(new StationContactData("N.A.", "09708910206"));
                break;
            case "dhurki ps":
                stationContactDatas.add(new StationContactData("N.A.", "09693549957"));
                break;
            case "manjhion ps":
                stationContactDatas.add(new StationContactData("06563287759", "08002831397"));
                break;
            case "bhawnathpur ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431101772"));
                break;
            case "meral ps":
                stationContactDatas.add(new StationContactData("06564228862", "09431362727"));
                break;
            case "kandi ps":
                stationContactDatas.add(new StationContactData("06563265624", "09798311048"));
                break;
            case "ranka ps":
                stationContactDatas.add(new StationContactData("06561254643", "09798546665"));
                break;
            case "garhwa ps":
                stationContactDatas.add(new StationContactData("06561222313", "09471740062"));
                break;

            // garhwa end
            // giridih start

            case "navdiha op":
                stationContactDatas.add(new StationContactData("N.A.", "09572355333"));
                break;
            case "parsan op":
                stationContactDatas.add(new StationContactData("N.A.", "09631527103"));
                break;
            case "madhuban op":
                stationContactDatas.add(new StationContactData("N.A.", "09934639101"));
                break;
            case "khukhra":
                stationContactDatas.add(new StationContactData("N.A.", "09955412301"));
                break;
            case "dumri ps":
                stationContactDatas.add(new StationContactData("06558233232", "09431706344"));
                break;
            case "town ps (giridih)":
                stationContactDatas.add(new StationContactData("06532222777", "09431706343"));
                break;
            case "lokai nayanpur ps":
                stationContactDatas.add(new StationContactData("N.A.", "08986639668"));
                break;
            case "taratand ps":
                stationContactDatas.add(new StationContactData("N.A.", "09693623666"));
                break;
            case "bhelwaghati ps":
                stationContactDatas.add(new StationContactData("N.A.", "09572355333"));
                break;
            case "deori ps":
                stationContactDatas.add(new StationContactData("06556234766", "09431706349"));
                break;
            case "gawan ps":
                stationContactDatas.add(new StationContactData("06556234040", "09431706348"));
                break;
            case "tisri ps":
                stationContactDatas.add(new StationContactData("06556234852", "09431706347"));
                break;
            case "pirtand ps":
                stationContactDatas.add(new StationContactData("06558231249", "09431706346"));
                break;
            case "nimiaghat ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706345"));
                break;
            case "birni ps":
                stationContactDatas.add(new StationContactData("06557244295", "07739466406"));
                break;
            case "bagodar ps":
                stationContactDatas.add(new StationContactData("06557233605", "09431706342"));
                break;
            case "sariya ps":
                stationContactDatas.add(new StationContactData("06557235677", "09431706341"));
                break;
            case "dhanwar ps":
                stationContactDatas.add(new StationContactData("06554235777", "09431706340"));
                break;
            case "hirodih ps":
                stationContactDatas.add(new StationContactData("06554", "09431706339"));
                break;
            case "jamua ps":
                stationContactDatas.add(new StationContactData("06554242278", "09431706338"));
                break;
            case "bengabad ps":
                stationContactDatas.add(new StationContactData("06532236504", "09431706337"));
                break;
            case "ahilyapur ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431706336"));
                break;
            case "gandey ps":
                stationContactDatas.add(new StationContactData("06532239262", "09431706335"));
                break;
            case "muffasil ps":
                stationContactDatas.add(new StationContactData("06532222753", "09431706333"));
                break;

            // giridih end
            // godda start

            case "rajabhitha":
                stationContactDatas.add(new StationContactData("N.A.", "09661853867"));
                break;
            case "hanwara ps":
                stationContactDatas.add(new StationContactData("N.A.", "09661854662"));
                break;
            case "boarijore ps":
                stationContactDatas.add(new StationContactData("06437255130", "09431134789"));
                break;
            case "belbadda ps":
                stationContactDatas.add(new StationContactData("06437261317", "09431134792"));
                break;
            case "mahagama ps":
                stationContactDatas.add(new StationContactData("06437228308", "09431134787"));
                break;
            case "poraiyahat ps":
                stationContactDatas.add(new StationContactData("06422258406", "09431134783"));
                break;
            case "muffasil ps (godda)":
                stationContactDatas.add(new StationContactData("06422222455", "09431134782"));
                break;
            case "town ps (godda)":
                stationContactDatas.add(new StationContactData("06422222027", "09431134781"));
                break;
            case "thakur gangti ps":
                stationContactDatas.add(new StationContactData("06437256616", "09431134790"));
                break;
            case "meharma ps":
                stationContactDatas.add(new StationContactData("06429282263", "09431134791"));
                break;
            case "lalmatia ps":
                stationContactDatas.add(new StationContactData("06437251042", "09431134788"));
                break;
            case "basantrai op":
                stationContactDatas.add(new StationContactData("06437260131", "09431134793"));
                break;
            case "pathargama ps":
                stationContactDatas.add(new StationContactData("06437268611", "09431134786"));
                break;
            case "deodand ps":
                stationContactDatas.add(new StationContactData("N.A.", "09431134784"));
                break;
            case "sunderpahari ps":
                stationContactDatas.add(new StationContactData("06422288116", "09431134785"));
                break;

            // godda end
            // gumla start

            case "sisai ps":
                stationContactDatas.add(new StationContactData("06524255409", "09431706214"));
                break;
            case "basia ps":
                stationContactDatas.add(new StationContactData("06533233349", "09431706211"));
                break;
            case "gumla ps":
                stationContactDatas.add(new StationContactData("06524223026", "09431706206"));
                break;
            case "raidih ps":
                stationContactDatas.add(new StationContactData("06536271336", "09431706210"));
                break;
            case "palkot ps":
                stationContactDatas.add(new StationContactData("06536273391", "09431706215"));
                break;
            case "kamdara ps":
                stationContactDatas.add(new StationContactData("06533232138", "09431706212"));
                break;
            case "ghaghra ps":
                stationContactDatas.add(new StationContactData("06523222454", "09431706207"));
                break;
            case "dumri ps (gumla)":
                stationContactDatas.add(new StationContactData("06535272326", "09431706209"));
                break;
            case "chainpur ps":
                stationContactDatas.add(new StationContactData("06535274446", "09431964846"));
                break;
            case "bharno ps":
                stationContactDatas.add(new StationContactData("06524254454", "09431706213"));
                break;
            case "bishunpur ps":
                stationContactDatas.add(new StationContactData("06523278433", "09431706208"));
                break;

            //gumla end
            // hazaribagh start

            case "fire brigade":
                stationContactDatas.add(new StationContactData("N.A.", "7870083266"));
                break;
            case "daru ps":
                stationContactDatas.add(new StationContactData("n.a.", "7250812078"));
                break;
            case "mahila thana and st-sc thana":
                stationContactDatas.add(new StationContactData("n.a.", "9431706325"));
                break;
            case "tatijhariya ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470197389"));
                break;
            case "bishnugarh ps":
                stationContactDatas.add(new StationContactData("06548237842", "09431706312"));
                break;
            case "urimari op":
                stationContactDatas.add(new StationContactData("n.a.", "09973502171"));
                break;
            case "ichak ps":
                stationContactDatas.add(new StationContactData("06548285500", "09431706311"));
                break;
            case "churchu ps":
                stationContactDatas.add(new StationContactData("06546230025", "09431706303"));
                break;
            case "charhi ps":
                stationContactDatas.add(new StationContactData("06546232850", "09470197390"));
                break;
            case "giddi ps":
                stationContactDatas.add(new StationContactData("06553273188", "09431706321"));
                break;
            case "padma op":
                stationContactDatas.add(new StationContactData("06546238140", "09430741399"));
                break;
            case "chauparan ps":
                stationContactDatas.add(new StationContactData("06547276528", "09431706318"));
                break;
            case "gorhar ps":
                stationContactDatas.add(new StationContactData("n.a.", "09431706317"));
                break;
            case "barkatha ps":
                stationContactDatas.add(new StationContactData("06543268110", "09431706316"));
                break;
            case "barhi ps":
                stationContactDatas.add(new StationContactData("06546266238", "09431706315"));
                break;
            case "keredari ps":
                stationContactDatas.add(new StationContactData("06551281001", "09431706314"));
                break;
            case "barkagaon ps":
                stationContactDatas.add(new StationContactData("06551283642", "09431706313"));
                break;
            case "katkamsandi ps":
                stationContactDatas.add(new StationContactData("06546238763", "09431706310"));
                break;
            case "pelawal op":
                stationContactDatas.add(new StationContactData("06546264050", "09431396617"));
                break;
            case "sadar ps (hazaribagh)":
                stationContactDatas.add(new StationContactData("06546223033", "09431706308"));
                break;
            case "muffasil ps (hazaribagh)":
                stationContactDatas.add(new StationContactData("06546223090", "09431482100"));
                break;

            // hazaribagh end
            // jamtara start

            case "mahila ps-sc-st ps ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470591047"));
                break;
            case "karmatar ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470591048"));
                break;
            case "fatehpur ps":
                stationContactDatas.add(new StationContactData("06428288155", "09470591049"));
                break;
            case "bagdheri ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470591042"));
                break;
            case "bindapathar ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470591044"));
                break;
            case "mihijam ps":
                stationContactDatas.add(new StationContactData("06433228433", "09470591039"));
                break;
            case "nala ps":
                stationContactDatas.add(new StationContactData("06428228725", "09470591040"));
                break;
            case "kundhit ps":
                stationContactDatas.add(new StationContactData("06428238230", "09470591041"));
                break;
            case "narayanpur ps":
                stationContactDatas.add(new StationContactData("06433288240", "09470591045"));
                break;
            case "jamtara ps":
                stationContactDatas.add(new StationContactData("06433222233", "09470591038"));
                break;

            // jamtara end
            // khunti start

            case "tapakara op":
                stationContactDatas.add(new StationContactData("06538275375", "09431180414"));
                break;
            case "karra ps":
                stationContactDatas.add(new StationContactData("06538271149", "09431706200"));
                break;
            case "rania ps":
                stationContactDatas.add(new StationContactData("06538278011", "09431706199"));
                break;
            case "torpa ps":
                stationContactDatas.add(new StationContactData("06538233385", "09431706198"));
                break;
            case "arki ps":
                stationContactDatas.add(new StationContactData("06530256139", "09431706195"));
                break;
            case "khunti ps":
                stationContactDatas.add(new StationContactData("06528220528", "09431706196"));
                break;
            case "murhu ps":
                stationContactDatas.add(new StationContactData("06538274488", "09431706197"));
                break;

            // khunti end
            // koderma start

            case "koderma ps":
                stationContactDatas.add(new StationContactData("06534252228", "09431706352"));
                break;
            case "tilaiya ps":
                stationContactDatas.add(new StationContactData("06534222544", "09431706355"));
                break;
            case "tealiya dam op":
                stationContactDatas.add(new StationContactData("06534235100", "09431706355"));
                break;
            case "chandwara op":
                stationContactDatas.add(new StationContactData("06534233160", "09431166566"));
                break;
            case "domchanchi op":
                stationContactDatas.add(new StationContactData("06534255521", "09431166566"));
                break;
            case "jainagar ps":
                stationContactDatas.add(new StationContactData("06534263034", "09431706356"));
                break;
            case "satgawan ps":
                stationContactDatas.add(new StationContactData("06534263047", "09431706357"));
                break;
            case "markacho ps":
                stationContactDatas.add(new StationContactData("06534265751", "09431706358"));
                break;

            // koderma end
            // latehar start

            case "mahila ps (latehar)":
                stationContactDatas.add(new StationContactData("n.a.", "09431342985"));
                break;
            case "bareshandh":
                stationContactDatas.add(new StationContactData("n.a.", "09430738677"));
                break;
            case "chhipadohar":
                stationContactDatas.add(new StationContactData("n.a.", "8686783813"));
                break;
            case "herhanj ps":
                stationContactDatas.add(new StationContactData("n.a.", "09334106261"));
                break;
            case "manika ps":
                stationContactDatas.add(new StationContactData("06567241344", "07050631710"));
                break;
            case "latehar ps":
                stationContactDatas.add(new StationContactData("06565247642", "09431208252"));
                break;
            case "netarhat ps":
                stationContactDatas.add(new StationContactData("06569277663", "09431706280"));
                break;
            case "mmahuadand ps":
                stationContactDatas.add(new StationContactData("06569252353", "09431706279"));
                break;
            case "garu ps":
                stationContactDatas.add(new StationContactData("06569242211", "09431706278"));
                break;
            case "barwadih ps":
                stationContactDatas.add(new StationContactData("06567288228", "09431706277"));
                break;
            case "balumath ps":
                stationContactDatas.add(new StationContactData("06568266813", "09431706276"));
                break;
            case "chandwa ps":
                stationContactDatas.add(new StationContactData("06565226235", "09431706275"));
                break;

            // latehar end
            // lohardaga start

            case "st-sc-ahtu":
                stationContactDatas.add(new StationContactData("n.a.", "09431190055"));
                break;
            case "serendag":
                stationContactDatas.add(new StationContactData("n.a.", "09852307127"));
                break;
            case "bagru":
                stationContactDatas.add(new StationContactData("n.a.", "09771226310"));
                break;
            case "mahila ps (lohardaga)":
                stationContactDatas.add(new StationContactData("n.a.", "09431960788"));
                break;
            case "bhandra ps":
                stationContactDatas.add(new StationContactData("06526272240", "08987715565"));
                break;
            case "kairo ps":
                stationContactDatas.add(new StationContactData("n.a.", "09431091326"));
                break;
            case "kuru ps":
                stationContactDatas.add(new StationContactData("06526271242", "09431706221"));
                break;
            case "jowang ps":
                stationContactDatas.add(new StationContactData("n.a.", "09931548301"));
                break;
            case "kisko ps":
                stationContactDatas.add(new StationContactData("06526276214", "09431706223"));
                break;
            case "lohardaga ps":
                stationContactDatas.add(new StationContactData("06526224020", "09431706220"));
                break;
            case "senha ps":
                stationContactDatas.add(new StationContactData("06526275504", "09431706224"));
                break;

            // lohardaga end
            // pakur start

            case "sc-st ps":
                stationContactDatas.add(new StationContactData("n.a.", "09973702722"));
                break;
            case "malpahari op":
                stationContactDatas.add(new StationContactData("n.a.", "09973268328"));
                break;
            case "mahila ps (pakur)":
                stationContactDatas.add(new StationContactData("06435223420", "09546617789"));
                break;
            case "raddipur op":
                stationContactDatas.add(new StationContactData("06423228088", "08084821517"));
                break;
            case "pakuria ps":
                stationContactDatas.add(new StationContactData("06426250244", "09199652559"));
                break;
            case "littipara ps":
                stationContactDatas.add(new StationContactData("06435270050", "09523669095"));
                break;
            case "hiranpur ps":
                stationContactDatas.add(new StationContactData("06435268329", "09934095606"));
                break;
            case "town ps (pakur)":
                stationContactDatas.add(new StationContactData("06435222070", "09470591076"));
                break;
            case "pakur ps":
                stationContactDatas.add(new StationContactData("06435222070", "09431173715"));
                break;
            case "muffasil ps (pakur)":
                stationContactDatas.add(new StationContactData("06435220401", "09470591017"));
                break;
            case "amrapadha ps":
                stationContactDatas.add(new StationContactData("06423262667", "08521340831"));
                break;
            case "maheshpur ps":
                stationContactDatas.add(new StationContactData("06423228088", "08084995066"));
                break;

            // pakur end
            // palamu start

            case "town ps (palamu)":
                stationContactDatas.add(new StationContactData("06562222294", "09431706249"));
                break;
            case "sadar ps (palamu)":
                stationContactDatas.add(new StationContactData("06562240111", "09431706250"));
                break;
            case "padwa ps":
                stationContactDatas.add(new StationContactData("06560289696", "09431285582"));
                break;
            case "piprarand ps":
                stationContactDatas.add(new StationContactData("n.a.", "09162706322"));
                break;
            case "pandu ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470503973"));
                break;
            case "ramgarh ps (palamu)":
                stationContactDatas.add(new StationContactData("n.a.", "09431184872"));
                break;
            case "deori op":
                stationContactDatas.add(new StationContactData("06566222545", "09471147787"));
                break;
            case "satbarwa op":
                stationContactDatas.add(new StationContactData("06562254499", "09431706251"));
                break;
            case "terhashi ps":
                stationContactDatas.add(new StationContactData("06562290404", "09431362293"));
                break;
            case "manatu ps":
                stationContactDatas.add(new StationContactData("n.a.", "09431585746"));
                break;
            case "paton ps":
                stationContactDatas.add(new StationContactData("06560279497", "09431195378"));
                break;
            case "panki ps":
                stationContactDatas.add(new StationContactData("06562262370", "09431706261"));
                break;
            case "mohammadganj ps":
                stationContactDatas.add(new StationContactData("06566242291", "09431164149"));
                break;
            case "haidernagar ps":
                stationContactDatas.add(new StationContactData("06566232459", "09431706257"));
                break;
            case "hussainbad ps":
                stationContactDatas.add(new StationContactData("06566222237", "09431706256"));
                break;
            case "chattarpur ps":
                stationContactDatas.add(new StationContactData("06566285236", "09431706259"));
                break;
            case "hariharganj ps":
                stationContactDatas.add(new StationContactData("06566251610", "09431706260"));
                break;
            case "rehla ps":
                stationContactDatas.add(new StationContactData("06584262233", "09431706255"));
                break;
            case "nawdiha ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470969651"));
                break;
            case "bisrampur ps":
                stationContactDatas.add(new StationContactData("06584262278", "09431706254"));
                break;
            case "chainpur ps (palamu)":
                stationContactDatas.add(new StationContactData("06586251151", "09431706252"));
                break;
            case "lesliganj ps":
                stationContactDatas.add(new StationContactData("06562282619", "09431706253"));
                break;

            // palamu end
            // ramgarh start

            case "bhadani nagar op":
                stationContactDatas.add(new StationContactData("n.a.", "09431139428"));
                break;
            case "west bokaro op":
                stationContactDatas.add(new StationContactData("06545243881", "09470172872"));
                break;
            case "bhurkunda ps":
                stationContactDatas.add(new StationContactData("06546249700", "09431706323"));
                break;
            case "kujju op":
                stationContactDatas.add(new StationContactData("06545281266", "09431192296"));
                break;
            case "mandu ps":
                stationContactDatas.add(new StationContactData("06545264166", "09431706324"));
                break;
            case "rajrappa ps":
                stationContactDatas.add(new StationContactData("06553251977", "09931344824"));
                break;
            case "basal ps":
                stationContactDatas.add(new StationContactData("06553275577", "09934307206"));
                break;
            case "barkakana op":
                stationContactDatas.add(new StationContactData("06553254858", "09955454601"));
                break;
            case "ramgarh ps":
                stationContactDatas.add(new StationContactData("06553222012", "09431706319"));
                break;
            case "patratu ps":
                stationContactDatas.add(new StationContactData("06553286540", "09431706322"));
                break;
            case "gola ps":
                stationContactDatas.add(new StationContactData("06553274207", "09431706320"));
                break;

            // ramgarh end
            // ranchi start

            case "tupudana op":
                stationContactDatas.add(new StationContactData("06512291903", "09431706167"));
                break;
            case "tamar ps":
                stationContactDatas.add(new StationContactData("06530252472", "09431706193"));
                break;
            case "pandra op":
                stationContactDatas.add(new StationContactData("06512510002", "09431706878"));
                break;
            case "mackluskiganj ps":
                stationContactDatas.add(new StationContactData("n.a.", "09608316771"));
                break;
            case "gonda ps":
                stationContactDatas.add(new StationContactData("06512281266", "09431706162"));
                break;
            case "pundag ps":
                stationContactDatas.add(new StationContactData("n.a.", "09431706913"));
                break;
            case "bit mesra ps":
                stationContactDatas.add(new StationContactData("n.a.", "09955911474"));
                break;
            case "rahe op":
                stationContactDatas.add(new StationContactData("06530271077", "09431706194"));
                break;
            case "muri op":
                stationContactDatas.add(new StationContactData("06522290277", "08051206731"));
                break;
            case "narkopi ps":
                stationContactDatas.add(new StationContactData("n.a.", "099343133677"));
                break;
            case "nagri ps":
                stationContactDatas.add(new StationContactData("06512775702", "09431706176"));
                break;
            case "mahila ps (ranchi)":
                stationContactDatas.add(new StationContactData("06512210533", "08102302402"));
                break;
            case "burmu ps":
                stationContactDatas.add(new StationContactData("06531274110", "09431706190"));
                break;
            case "sc-st ps (ranchi)":
                stationContactDatas.add(new StationContactData("06512217993", "0941103958"));
                break;
            case "traffic ps (ranchi)":
                stationContactDatas.add(new StationContactData("06512317774", "09431706172"));
                break;
            case "tatisilway ps":
                stationContactDatas.add(new StationContactData("06512265789", "09431706174"));
                break;
            case "silli ps":
                stationContactDatas.add(new StationContactData("06522222700", "09431164807"));
                break;
            case "sikidiri ps":
                stationContactDatas.add(new StationContactData("06530252472", "09431706184"));
                break;
            case "sadar ps (ranchi)":
                stationContactDatas.add(new StationContactData("06512544625", "09431706160"));
                break;
            case "angara ps":
                stationContactDatas.add(new StationContactData("06522272024", "09431706180"));
                break;
            case "mandar ps":
                stationContactDatas.add(new StationContactData("06531224581", "09431706187"));
                break;
            case "lapung ps":
                stationContactDatas.add(new StationContactData("06529271010", "09431706178"));
                break;
            case "lalpur ps":
                stationContactDatas.add(new StationContactData("06512203754", "09431706159"));
                break;
            case "kotwali ps":
                stationContactDatas.add(new StationContactData("06512200968", "09431706158"));
                break;
            case "kanke ps":
                stationContactDatas.add(new StationContactData("06512230734", "09431706185"));
                break;
            case "etki ps":
                stationContactDatas.add(new StationContactData("06529227243", "09431706177"));
                break;
            case "dhurwa ps":
                stationContactDatas.add(new StationContactData("06512408299", "09431706166"));
                break;
            case "daily market ps":
                stationContactDatas.add(new StationContactData("06512308685", "09431706163"));
                break;
            case "chanho ps":
                stationContactDatas.add(new StationContactData("06531274362", "09431706189"));
                break;
            case "bundu ps":
                stationContactDatas.add(new StationContactData("06530222251", "09431706191"));
                break;
            case "argora ps":
                stationContactDatas.add(new StationContactData("06512242132", "09431706170"));
                break;
            case "khelari ps":
                stationContactDatas.add(new StationContactData("06531246410", "09431706188"));
                break;
            case "bero ps":
                stationContactDatas.add(new StationContactData("06529277376", "09431706179"));
                break;
            case "pithoria ps":
                stationContactDatas.add(new StationContactData("06512475432", "09431706186"));
                break;
            case "ratu ps":
                stationContactDatas.add(new StationContactData("06512521424", "09431706175"));
                break;
            case "sonahatu ps":
                stationContactDatas.add(new StationContactData("06530274043", "09431706192"));
                break;
            case "oramanjhi ps":
                stationContactDatas.add(new StationContactData("06512576523", "09431706183"));
                break;
            case "namkum ps":
                stationContactDatas.add(new StationContactData("06512261900", "09431706173"));
                break;
            case "jagnnathpur ps":
                stationContactDatas.add(new StationContactData("06512442692", "09431706169"));
                break;
            case "hindipiri ps":
                stationContactDatas.add(new StationContactData("06512205409", "09431706164"));
                break;
            case "chutia ps":
                stationContactDatas.add(new StationContactData("06512461880", "09431706165"));
                break;
            case "lower bazar ps":
                stationContactDatas.add(new StationContactData("06512351002", "09431706171"));
                break;
            case "bariyatu ps":
                stationContactDatas.add(new StationContactData("06512542660", "09431706161"));
                break;
            case "sukhdeo nagar ps":
                stationContactDatas.add(new StationContactData("06512284509", "08521605643"));
                break;
            case "doranda ps":
                stationContactDatas.add(new StationContactData("06512481057", "09431706168"));
                break;

            // racnhi end
            // sahibganj start

            case "zirwabari op":
                stationContactDatas.add(new StationContactData("06436223788", "09470591087"));
                break;
            case "barhet ps":
                stationContactDatas.add(new StationContactData("06426268820", "09470591090"));
                break;
            case "borio ps":
                stationContactDatas.add(new StationContactData("06436252002", "09470591089"));
                break;
            case "muffasil ps (sahibganj)":
                stationContactDatas.add(new StationContactData("06436223557", "09470591086"));
                break;
            case "town ps (sahibganj)":
                stationContactDatas.add(new StationContactData("06436222002", "09470591084"));
                break;
            case "kotalpokhar ps":
                stationContactDatas.add(new StationContactData("06435242031", "09470591098"));
                break;
            case "ranga ps":
                stationContactDatas.add(new StationContactData("06426278748", "09470591099"));
                break;
            case "barharwa ps":
                stationContactDatas.add(new StationContactData("n.a.", "09470591097"));
                break;
            case "radhanagar ps":
                stationContactDatas.add(new StationContactData("06426276439", "09470591096"));
                break;
            case "taljhari ps (sahibganj)":
                stationContactDatas.add(new StationContactData("06426246313", "09470591094"));
                break;
            case "raj mahal ps":
                stationContactDatas.add(new StationContactData("06426228130", "09470591095"));
                break;
            case "mirzachowki ps":
                stationContactDatas.add(new StationContactData("06436244268", "09470591093"));
                break;

            // sahibganj end
            // saraikela start

            case "kapali op":
                stationContactDatas.add(new StationContactData("n.a.", "09431117980"));
                break;
            case "adityapur ps":
                stationContactDatas.add(new StationContactData("06572372666", "09431706535"));
                break;
            case "tiruldih op":
                stationContactDatas.add(new StationContactData("n.a.", "09955715162"));
                break;
            case "humid op":
                stationContactDatas.add(new StationContactData("06591232025", "06591232428"));
                break;
            case "amda op":
                stationContactDatas.add(new StationContactData("06583252798", "06583252798"));
                break;
            case "r.i.t. ps":
                stationContactDatas.add(new StationContactData("06572370001", "09431706542"));
                break;
            case "saraikela ps":
                stationContactDatas.add(new StationContactData("06597234646", "08757888805"));
                break;
            case "nimdih ps":
                stationContactDatas.add(new StationContactData("06591233339", "09431706545"));
                break;
            case "ichagarh ps":
                stationContactDatas.add(new StationContactData("06591283438", "09431706546"));
                break;
            case "chowka ps":
                stationContactDatas.add(new StationContactData("n.a.", "09973763515"));
                break;
            case "chandil ps":
                stationContactDatas.add(new StationContactData("06591236531", "09431706544"));
                break;
            case "kandra op":
                stationContactDatas.add(new StationContactData("06597255380", "09431706547"));
                break;
            case "gamharia ps":
                stationContactDatas.add(new StationContactData("06572386500", "09431706541"));
                break;
            case "dalbhanga op":
                stationContactDatas.add(new StationContactData("n.a.", "09798423588"));
                break;
            case "kuchai ps":
                stationContactDatas.add(new StationContactData("06583253206", "065832892400"));
                break;
            case "kharsawan ps":
                stationContactDatas.add(new StationContactData("06583254947", "09431706538"));
                break;
            case "raj nagar ps":
                stationContactDatas.add(new StationContactData("06597252275", "09431706540"));
                break;

            // saraikela end
            // simdega start

            case "bano ps":
                stationContactDatas.add(new StationContactData("06527275723", "09431706236"));
                break;
            case "kersai ps":
                stationContactDatas.add(new StationContactData("n.a.", "09801511346"));
                break;
            case "mahila ps (simdega)":
                stationContactDatas.add(new StationContactData("n.a.", "08102124019"));
                break;
            case "sc-st ps (simdega)":
                stationContactDatas.add(new StationContactData("n.a.", "09939642074"));
                break;
            case "kolebira ps":
                stationContactDatas.add(new StationContactData("06527265511", "09431706235"));
                break;
            case "bolwa ps":
                stationContactDatas.add(new StationContactData("06539266219", "09431706234"));
                break;
            case "simdega ps":
                stationContactDatas.add(new StationContactData("06525226251", "09431706231"));
                break;
            case "thetaitangar ps":
                stationContactDatas.add(new StationContactData("06525273147", "09431706232"));
                break;
            case "orga op":
                stationContactDatas.add(new StationContactData("n.a.", "09431338193"));
                break;
            case "kurdeg ps":
                stationContactDatas.add(new StationContactData("06525255254", "09431706233"));
                break;
            case "jaldega ps":
                stationContactDatas.add(new StationContactData("06527277227", "09431706237"));
                break;
            case "girda op":
                stationContactDatas.add(new StationContactData("n.a.", "09955105027"));
                break;
            case "bansjhor op":
                stationContactDatas.add(new StationContactData("n.a.", "09431398582"));
                break;

            // simdega end
            // west singhbhum start

            case "ckp top-3":
                stationContactDatas.add(new StationContactData("06587236634", "09430755506"));
                break;
            case "ckp top-2":
                stationContactDatas.add(new StationContactData("06587236589", "09431933604"));
                break;
            case "ckp top-1":
                stationContactDatas.add(new StationContactData("06587236612", "09576656308"));
                break;
            case "sadar top":
                stationContactDatas.add(new StationContactData("06582259600", "09631087677"));
                break;
            case "jetya":
                stationContactDatas.add(new StationContactData("n.a.", "08804667595"));
                break;
            case "tebo ps":
                stationContactDatas.add(new StationContactData("n.a.", "09955008098"));
                break;
            case "jaraikella ps":
                stationContactDatas.add(new StationContactData("06593287744", "09431949171"));
                break;
            case "jamda op":
                stationContactDatas.add(new StationContactData("06596262254", "09471509440"));
                break;
            case "chhotanagra ps":
                stationContactDatas.add(new StationContactData("n.a.", "09431394254"));
                break;
            case "nowamundi ps":
                stationContactDatas.add(new StationContactData("06596233300", "09431706473"));
                break;
            case "kiriburu ps":
                stationContactDatas.add(new StationContactData("06596244986", "09431706471"));
                break;
            case "muffasil ps (west singhbhum)":
                stationContactDatas.add(new StationContactData("06582256842", "09431706463"));
                break;
            case "sadar ps (west singhbhum)":
                stationContactDatas.add(new StationContactData("06582256841", "09431706462"));
                break;
            case "chiriya op":
                stationContactDatas.add(new StationContactData("06593287745", "09431167928"));
                break;
            case "tatanagar op":
                stationContactDatas.add(new StationContactData("06589285405", "09430506738"));
                break;
            case "chakradharpur ps":
                stationContactDatas.add(new StationContactData("06587238027", "09431706465"));
                break;
            case "pandrashali op":
                stationContactDatas.add(new StationContactData("06582282233", "09835785748"));
                break;
            case "jhinkpani ps":
                stationContactDatas.add(new StationContactData("06589235606", "09431706475"));
                break;
            case "manjhari ps":
                stationContactDatas.add(new StationContactData("06589285334", "09431706464"));
                break;
            case "hatgamharia ps":
                stationContactDatas.add(new StationContactData("06589233378", "09431706479"));
                break;
            case "majhgaon ps":
                stationContactDatas.add(new StationContactData("06588244055", "09431151834"));
                break;
            case "kumardungi ps":
                stationContactDatas.add(new StationContactData("0658826661", "08084761004"));
                break;
            case "jaganathpur ps":
                stationContactDatas.add(new StationContactData("06588252699", "09431706474"));
                break;
            case "toklo ps":
                stationContactDatas.add(new StationContactData("06587288308", "09431066741"));
                break;
            case "tonto ps":
                stationContactDatas.add(new StationContactData("06589235616", "09431706476"));
                break;
            case "goilkera ps":
                stationContactDatas.add(new StationContactData("06587224206", "09431706470"));
                break;
            case "gua ps":
                stationContactDatas.add(new StationContactData("06596263860", "09431706472"));
                break;
            case "sonua ps":
                stationContactDatas.add(new StationContactData("06587277210", "09431706468"));
                break;
            case "karaikela ps":
                stationContactDatas.add(new StationContactData("06587244266", "09431706466"));
                break;
            case "bandgaon ps":
                stationContactDatas.add(new StationContactData("06587255216", "09431706467"));
                break;
            case "manoharpur ps":
                stationContactDatas.add(new StationContactData("06593232513", "09431706469"));
                break;

            // west singhbhum end

        }

        // loading the listview
        StationContactDataAdapter dataAdapter = new StationContactDataAdapter(StationContactDetailsActivity.this, stationContactDatas);
        listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(dataAdapter);
    }}

