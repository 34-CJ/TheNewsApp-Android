package com.hja.thenewsapp.ui.fragments

import android.os.Bundle
import android.view.View
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import com.hja.thenewsapp.R
import com.hja.thenewsapp.databinding.FragmentArticleBinding
import com.hja.thenewsapp.ui.NewsActivity
import com.hja.thenewsapp.ui.NewsViewModel

class ArticleFragment : Fragment(R.layout.fragment_article) {

    lateinit var newsViewModel: NewsViewModel
    val args: ArticleFragmentArgs by navArgs()
    lateinit var binding: FragmentArticleBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentArticleBinding.bind(view)

        // 获取 Activity 里的 ViewModel
        newsViewModel = (activity as NewsActivity).newsViewModel

        // 获取传递过来的 article 对象
        val article = args.article

        binding.webView.apply {
            webViewClient = WebViewClient() // 确保在当前 App 打开，不跳到系统浏览器
            article.url?.let { loadUrl(it) } // 加载文章网址
        }
        binding.fab.setOnClickListener{
            newsViewModel.addToFavourites(article)
            Snackbar.make(view,"Added to favourites", Snackbar.LENGTH_SHORT).show()

        }
    }


}