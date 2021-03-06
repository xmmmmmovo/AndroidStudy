package com.nuc.gallery.view


import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.nuc.gallery.R
import com.nuc.gallery.model.GalleryViewModel
import kotlinx.android.synthetic.main.fragment_gallary.*

/**
 * A simple [Fragment] subclass.
 */
class GallaryFragment : Fragment() {
    private lateinit var galleryViewModel: GalleryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallary, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.refreshItem -> {
                swipeRefreshGallary.isRefreshing = true
                galleryViewModel.fetchData()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        setHasOptionsMenu(true)
        val galleryAdapter = GalleryAdapter()
        recyclerViewGallary.apply {
            adapter = galleryAdapter
            layoutManager = StaggeredGridLayoutManager(
                2,
                StaggeredGridLayoutManager.VERTICAL
            )
        }

        galleryViewModel = ViewModelProvider(
            this,
            ViewModelProvider.AndroidViewModelFactory(
                requireActivity().application
            )
        )
            .get(GalleryViewModel::class.java)
        galleryViewModel.photoListLive.observe(this, Observer {
            galleryAdapter.submitList(it)
            swipeRefreshGallary.isRefreshing = false
        })

        galleryViewModel.photoListLive.value ?: galleryViewModel.fetchData()

        swipeRefreshGallary.setOnRefreshListener {
            galleryViewModel.fetchData()
        }

        recyclerViewGallary.addOnScrollListener(
            object : RecyclerView.OnScrollListener() {
                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)
                    if (dy < 0) {
                        return
                    }

                    val layoutManager = recyclerView.layoutManager
                            as StaggeredGridLayoutManager

                    val intArray = IntArray(2)
                    layoutManager.findLastVisibleItemPositions(intArray)

                    if (intArray[0] == galleryAdapter.itemCount - 1) {

                    }
                }
            })
    }

}
