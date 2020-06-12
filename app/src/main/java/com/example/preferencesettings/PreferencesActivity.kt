package com.example.preferencesettings

import android.graphics.Color
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat
import kotlinx.android.synthetic.main.activity_preferences.*


class PreferencesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)


        if(savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.framelayout,MainPreference()).commit()
        }


    }

    class MainPreference : PreferenceFragmentCompat(){
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
             setPreferencesFromResource(R.xml.preferences,rootKey)
             var switchreference = preferenceManager.findPreference("Switch")
             switchreference.setOnPreferenceChangeListener(object : Preference.OnPreferenceChangeListener{
                 override fun onPreferenceChange(preference: Preference?, newValue: Any?): Boolean {
                     var isChecked = newValue as Boolean
                     if(isChecked){
                         Toast.makeText(context,"It is checked",Toast.LENGTH_SHORT).show()
                     }else {
                         Toast.makeText(context,"It is not checked",Toast.LENGTH_SHORT).show()
                     }
                     return false
                 }
             })


        }
    }

}