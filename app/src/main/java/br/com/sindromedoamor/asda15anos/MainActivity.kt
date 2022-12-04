package br.com.sindromedoamor.asda15anos

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import br.com.sindromedoamor.asda15anos.fragments.CadastreSeuFilhoFragment
import br.com.sindromedoamor.asda15anos.fragments.LinksFragment
import br.com.sindromedoamor.asda15anos.fragments.ReservaHotelFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.toolbar.*

class MainActivity : AppCompatActivity() {

    private val drawerToggle: ActionBarDrawerToggle by lazy {
        ActionBarDrawerToggle(this,
            drawerLayout, toolbar, R.string.app_name, R.string.app_name)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        drawerLayout.addDrawerListener(drawerToggle)
        drawerToggle.syncState()
        navigationView.setNavigationItemSelectedListener { menuItem ->
            selectMenuOption(menuItem)
            true
        }
        loadLinks()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                drawerLayout.openDrawer(GravityCompat.START)
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun selectMenuOption(menuItem: MenuItem) {
        menuItem.isCheckable = true
        drawerLayout.closeDrawers()
        val title = menuItem.title.toString()

        when (title) {
            getString(R.string.home) -> {
                loadLinks()
            }
            getString(R.string.menu_cadastre_seu_filtro) -> {
                val cadastreSeuFilhoFragment = CadastreSeuFilhoFragment.newInstance()
                openFragment(cadastreSeuFilhoFragment)

            }
            getString(R.string.menu_reserva_hotel) -> {
                val reservaHotelFragment = ReservaHotelFragment.newInstance()
                openFragment(reservaHotelFragment)
            }
        }
    }

    private fun loadLinks() {
        val linksFragment = LinksFragment.newInstance()
        openFragment(linksFragment)
    }

    private fun openFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.content, fragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()
    }
}