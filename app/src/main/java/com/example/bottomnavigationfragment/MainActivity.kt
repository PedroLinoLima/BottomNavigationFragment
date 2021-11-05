package com.example.bottomnavigationfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    // Botões
    lateinit var btnHome: Button
    lateinit var btnCliente: Button
    lateinit var btnBusca: Button

    // Fragmentos
    lateinit var homeFragment: HomeFragment
    lateinit var clienteFragment: ClienteFragment
    lateinit var buscaFragment: BuscaFragment
    lateinit var testeFragment: TesteFragment

    // Toolbar
    lateinit var toolbar: Toolbar

    lateinit var bottomNavigation: BottomNavigationView

    lateinit var navigation: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBusca = findViewById(R.id.btn_busca)
        btnCliente = findViewById(R.id.btn_clientes)
        btnHome = findViewById(R.id.btn_home)

        buscaFragment = BuscaFragment()
        clienteFragment = ClienteFragment()
        homeFragment = HomeFragment()
        testeFragment = TesteFragment()

        bottomNavigation = findViewById(R.id.bottom_navigation)

        navigation = findViewById(R.id.navigation)

        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        toolbar.setTitle("Teste Drawer")

        setFragment(homeFragment)

        btnHome.setOnClickListener {
            setFragment(homeFragment)
        }

        btnCliente.setOnClickListener {
            setFragment(clienteFragment)
        }

        btnBusca.setOnClickListener {
            setFragment(buscaFragment)
        }

        bottomNavigation.setOnItemSelectedListener { item ->
            onNavigationItemSelected(item)
            true
        }

        navigation.setNavigationItemSelectedListener { item ->
            onNavigationItemSelected(item)
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame, fragment)
        fragmentTransaction.commit()
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when(item.itemId) {
            R.id.menu_home -> {
                setFragment(homeFragment)
            }
            R.id.menu_cliente -> {
                setFragment(clienteFragment)
            }
            R.id.menu_busca -> {
                setFragment(buscaFragment)
            } else -> {
                setFragment(testeFragment)
            }
        }

        return true

    }

}