package com.example.a6_month_4_hw.core.base

    import android.os.Bundle
    import androidx.appcompat.app.AppCompatActivity
    import androidx.viewbinding.ViewBinding

    abstract class BaseActivity<VB : ViewBinding> : AppCompatActivity() {

        protected lateinit var binding: VB

        protected abstract fun inflateViewBinding(): VB

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = inflateViewBinding()
            setContentView(binding.root)

            checkInternet()
            setUI()
            setupLiveData()
            initClickListener()

        }

        open fun setupLiveData() {}

        open fun setUI() {}

        open fun initClickListener() {}

        open fun checkInternet() {}
    }
