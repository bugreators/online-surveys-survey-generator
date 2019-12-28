package mk.finki.ukim.dians.maiserver.mail.server.service

import org.thymeleaf.context.Context

interface MailService {
    fun sendTextMail( to:String,subject:String,body:String,cc:String,bcc:String)
    fun sendHtmlMail(to: Array<Any>, subject:String, templateName:String, context: Context)
}
