package com.sample.libraryhostsample

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.sample.empasssamplelibrary.Constants
import com.sample.empasssamplelibrary.PaymentActivity
import com.sample.empasssamplelibrary.PaymentDetails
import com.sample.empasssamplelibrary.setDetails
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnPay.setOnClickListener {
            if (validate()) {
                val intent = Intent(this@MainActivity, PaymentActivity::class.java)
                intent.setDetails(getPaymentDetails())
                startActivityForResult(intent, Constants.INTENT_PAY)
            } else {
                showToast("All fields are mandatory.")
            }
        }
    }

    private fun validate() = productNameLayout.getText().isNotEmpty() && productAmountLayout.getText().isNotEmpty()

    private fun getPaymentDetails() = PaymentDetails(
        amount = productAmountLayout.getText(),
        productName = productNameLayout.getText(),
        productId = 4,
        time = HostConstants.TIME_FORMAT.format(System.currentTimeMillis())
    )

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == resultCode)
            showToast("Payment Success")
    }
}
