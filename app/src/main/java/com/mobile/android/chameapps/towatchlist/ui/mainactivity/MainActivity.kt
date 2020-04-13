package com.mobile.android.chameapps.towatchlist.ui.mainactivity

import android.app.Dialog
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.Window
import android.view.WindowManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.ui.AppBarConfiguration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mobile.android.chameapps.towatchlist.R
import com.mobile.android.chameapps.towatchlist.room.entities.Item
import com.mobile.android.chameapps.towatchlist.tools.Util
import com.mobile.android.chameapps.towatchlist.ui.adapter.RecyclerViewAdapter
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import io.reactivex.subjects.CompletableSubject
import javax.inject.Inject

class MainActivity : AppCompatActivity(), HasSupportFragmentInjector, LifecycleOwner {

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: MainActivityViewModel

    private lateinit var recyclerView: RecyclerView

    private lateinit var appBarConfiguration: AppBarConfiguration

    val onDestroyCompletable = CompletableSubject.create()

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

        viewModel = ViewModelProviders.of(this, viewModelFactory).get(MainActivityViewModel::class.java)
        viewModel.getItems().observe(this, itemsUpdateObserver)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            showAddDialog()
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        appBarConfiguration = AppBarConfiguration(setOf(
            R.id.nav_home,
            R.id.nav_settings
        ), drawerLayout)

        recyclerView = findViewById(R.id.recycler_view)
    }

    override fun supportFragmentInjector() = dispatchingAndroidInjector

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    fun showAddDialog() {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE) // before
        dialog.setContentView(R.layout.dialog_add_item)
        dialog.setCancelable(true)

        val lp = WindowManager.LayoutParams()
        lp.copyFrom(dialog.window!!.attributes)
        lp.width = WindowManager.LayoutParams.WRAP_CONTENT
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT

        val title = dialog.findViewById<View>(R.id.enter_title) as EditText
        (dialog.findViewById<View>(R.id.bt_cancel) as AppCompatButton).setOnClickListener(
            { dialog.dismiss() })

        (dialog.findViewById<View>(R.id.bt_submit) as AppCompatButton).setOnClickListener(
            {
                viewModel.insert(Item(title.text.toString(), Util.getCurrentTime(), 5.0))
                dialog.dismiss()
            })

        dialog.show()
        dialog.window!!.attributes = lp
    }

    var itemsUpdateObserver = Observer<List<Item>> { items ->
        val recyclerViewAdapter = RecyclerViewAdapter(this, items)
        recyclerView.setLayoutManager(LinearLayoutManager(applicationContext))
        recyclerView.setAdapter(recyclerViewAdapter)
    }
}
