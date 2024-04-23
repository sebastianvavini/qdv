package com.sebastiaomoura.qdv

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.sebastiaomoura.qdv.databinding.ActivityMainBinding

@Suppress("UNREACHABLE_CODE")
class MainActivity : AppCompatActivity() {
    private lateinit var  binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(MeditaFragment())

        var bottomNav = binding.bottomNav // findViewById<BottomNavigationView>(R.id.bottomNav)


        bottomNav.setOnItemSelectedListener {
            when (it.itemId){

                R.id.chat -> {
                    loadFragment(ChatFragment())
                    true
                }
                R.id.new_game ->{
                    loadFragment(MeditaFragment())
                    true
                }
                R.id.new_sono ->{
                    loadFragment(SonoFragment())
                    true
                }
                R.id.fisico -> {
                    loadFragment(FisicoFragment())
                    true
                }
                R.id.alimento -> {
                    loadFragment(AlimentoFragment())
                    true
                }



                else -> {
                    println("else aqui")
                    true
                }
            }

        }

    }

    // look at this section
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.basic_menu,menu)
        return super.onCreateOptionsMenu(menu)




    }
    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }
}