package com.weight68kg.jetpackdemo.detail

import android.content.Intent
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.ChangeTransform
import android.transition.Fade
import android.transition.TransitionSet
import android.view.MenuItem
import android.view.Window
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.weight68kg.jetpackdemo.R


/**
 * An activity representing a single Item detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [ItemListActivity].
 */
class ItemDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_item_detail)
        setSupportActionBar(findViewById(R.id.detail_toolbar))

        val iv_top=findViewById<ImageView>(R.id.iv_top)
        /**
         * 1、设置相同的TransitionName
         */
        /**
         * 1、设置相同的TransitionName
         */
        ViewCompat.setTransitionName(iv_top, "avatar:" )
        /**
         * 2、设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
         */
        /**
         * 2、设置WindowTransition,除指定的ShareElement外，其它所有View都会执行这个Transition动画
         */
        window.enterTransition = Fade()
        window.exitTransition = Fade()
        /**
         * 3、设置ShareElementTransition,指定的ShareElement会执行这个Transiton动画
         */
        /**
         * 3、设置ShareElementTransition,指定的ShareElement会执行这个Transiton动画
         */
        val transitionSet = TransitionSet()
        transitionSet.addTransition(ChangeBounds())
        transitionSet.addTransition(ChangeTransform())
        transitionSet.addTarget(iv_top)
        getWindow().setSharedElementEnterTransition(transitionSet);
        getWindow().setSharedElementExitTransition(transitionSet);

        findViewById<FloatingActionButton>(R.id.fab).setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own detail action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // savedInstanceState is non-null when there is fragment state
        // saved from previous configurations of this activity
        // (e.g. when rotating the screen from portrait to landscape).
        // In this case, the fragment will automatically be re-added
        // to its container so we don"t need to manually add it.
        // For more information, see the Fragments API guide at:
        //
        // http://developer.android.com/guide/components/fragments.html
        //
        if (savedInstanceState == null) {
            // Create the detail fragment and add it to the activity
            // using a fragment transaction.
            val fragment = ItemDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(
                        ItemDetailFragment.ARG_ITEM_ID,
                        intent.getStringExtra(ItemDetailFragment.ARG_ITEM_ID)
                    )
                }
            }

            supportFragmentManager.beginTransaction()
                .add(R.id.item_detail_container, fragment)
                .commit()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem) =
        when (item.itemId) {
            android.R.id.home -> {

                // This ID represents the Home or Up button. In the case of this
                // activity, the Up button is shown. For
                // more details, see the Navigation pattern on Android Design:
                //
                // http://developer.android.com/design/patterns/navigation.html#up-vs-back

                navigateUpTo(Intent(this, ItemListActivity::class.java))

                true
            }
            else -> super.onOptionsItemSelected(item)
        }
}