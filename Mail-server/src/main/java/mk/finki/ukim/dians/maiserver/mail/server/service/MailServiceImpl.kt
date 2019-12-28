package mk.finki.ukim.dians.maiserver.mail.server.service

import org.springframework.boot.autoconfigure.mail.MailProperties
import org.springframework.core.io.ByteArrayResource
import org.springframework.mail.MailSender
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.scheduling.annotation.Async
import org.springframework.stereotype.Service
import org.thymeleaf.TemplateEngine
import org.thymeleaf.context.Context
import java.io.IOException
import java.io.UnsupportedEncodingException
import java.nio.file.Files
import java.nio.file.Paths
import javax.mail.MessagingException


@Service
class MailServiceImpl(
        private val mailSender: MailSender,
        private val javaMailSender: JavaMailSender,
        private val templateEngine: TemplateEngine,
        private val mailProperties: MailProperties
) : MailService {


    @Async
    @Throws(MessagingException::class)
    override fun sendTextMail(to: String, subject: String, body: String, cc: String, bcc: String) {
        val message = SimpleMailMessage()
        message.setFrom("eimtfinki2019@gmail.com")
        message.setTo(to)
        message.setText(body)
        message.setSubject(subject)
        if (cc != "") message.setCc(cc)
        if (bcc != "") message.setBcc(bcc)
        mailSender.send(message)
    }

    @Async
    @Throws(MessagingException::class)
    override fun sendHtmlMail(to: Array<Any>, subject: String, templateName: String, context: Context) {
        val mail = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(mail, true)
        try {
            mailProperties.properties["from"]?.let { mailProperties.properties["personal"]?.let { it1 -> helper.setFrom(it, it1) } }
        } catch (e: UnsupportedEncodingException) {
        }
        val attendees = to.map { it.toString() }.toTypedArray()
        val path = Paths.get("/home/vtodev/IdeaProjects/schedule-maker/src/main/resources/static/image/Logca-za-wordLogo.png")
        val name = "Logca-za-wordLogo.png"
        val originalFileName = "Logca-za-wordLogo.png"
        val contentType = "image/png"
        var content: ByteArray? = null
        try {
            content = Files.readAllBytes(path)
        } catch (e: IOException) {
        }
        val imageSource = content?.let { ByteArrayResource(it) }
        context.setVariable("imageResourceName",name)



        val body = templateEngine.process(templateName, context)

        helper.setTo(attendees)
        helper.setSubject(subject)
        helper.setText(body, true)
//        helper.addInline(name, imageSource!!, contentType)
        javaMailSender.send(mail)


    }

}
