# Conference
Learn to test drive an Android application by applying MVP and MVVM design patterns

# Setup Instructions
- Install Android Studio - version 2.1 or above
- Install JDK 1.8
- Install Google Play Services v 30 or above
- Install Google Repository v 26 or above

## Application Mockups
<img src="https://photos-4.dropbox.com/t/2/AABFuuxuiRfJMxcFQYs8CSIeN3uyE_F9gxC26POPiwry5Q/12/35633698/png/32x32/3/1473350400/0/2/AgendaScreen.png/EPzSiRsY7DEgBygH/vqnU_p8D_Y4BVLO142J7Ac4KWccPHUXUA9ZCBDNiiFQ?size_mode=3&dl=0&size=320x240" alt="Screenshot"/> <img src="https://photos-6.dropbox.com/t/2/AACbYSgS0XkKCy4MXoXPMgXca5rHexl_mIWS92TqFZBAhw/12/35633698/png/32x32/3/1473418800/0/2/StarredSession.png/EPzSiRsY7jEgBygH/05IIGFMG1e62bXWy_rIHXdWuHr9T8UVT5yKErIGhWoM?size_mode=3&dl=0&size=320x240" alt="Screenshot"/><img src="https://photos-2.dropbox.com/t/2/AAAcE5p4OQPAikMPYYOCvVOkdPHIbQ65SvrTZssoM7ik2g/12/35633698/png/32x32/3/1473418800/0/2/DetailsScreen.png/EPzSiRsY7jEgBygH/NAg5lJ9b9TTeXX2-hknKmGbeZFeF1ObEodgEJF1NVns?size_mode=3&dl=0&size=320x240" alt="Screenshot"/><img src="https://photos-1.dropbox.com/t/2/AADaiD8EUr6OKVCXIr_l6VGm6JernXVkw4rRMASdgB3s6A/12/35633698/png/32x32/3/1473418800/0/2/ConflictingSession.png/EPzSiRsY7jEgBygH/bhdlWtcqECRvOYfMFA0s3PO46i6ZCpsWoFNulAaLzgA?size_mode=3&dl=0&size=320x240" alt="Screenshot"/>

## Sample Data Format

```
{
   "sessions":[
      {
         "category":"ASPIRE",
         "description":"This is a short inspirational talk on how we forget our dream over time, and how to not forget them.",
         "endTime":"2016-09-23T10:30:00+05:30",
         "location":"Pre-function area",
         "name":"Protect your Dream",
         "startTime":"2016-09-23T09:00:00+05:30"
      },
      {
         "category":"BELONG",
         "description":"Art reflects the societal conditions in which it is produced. This applies to even Bollywood where fantasy and escapism have always been dominant themes.Raj Kapoor's characters in movies like Awara mirror the innocent optimism prevalent in the country just after Independence. Amitabh Bachhan's Angry Young Man channelised the frustration of a country that was sensing that the supposed benefits of industralisation wouldn't reach everyone. In more recent times, 'Shahid' reflects communal tensions while Zindagi Na Milegi Dobara is unabashedly a \"first world movie\" that celebrates conspicuous consumption and neo-liberalism.In 40 whirlwind minutes, I will use short clips from popular movies to help the audience understand modern India's evolving national agenda, our hopes and aspirations, and... yes, our collective failings as a nation.",
         "endTime":"2016-09-23T11:15:00+05:30",
         "location":"Grand Ballroom",
         "name":"Awara to Zindagi Na Milegi Dobara: understanding modern India through our movies",
         "startTime":"2016-09-23T10:15:00+05:30"
      },
      {
         "category":"CREATE",
         "description":"If you haven't already seen the awesome projects being showcased at the experience zones, this is your chance to stop by!",
         "endTime":"2016-09-23T11:15:00+05:30",
         "location":"Grand Ballroom - A1",
         "name":"IoTT",
         "startTime":"2016-09-23T09:15:00+05:30"
      },
      {
         "category":"CREATE",
         "description":"This talks covers the lessons learned around software interacting with hardware",
         "endTime":"2016-09-23T12:15:00+05:30",
         "location":"Grand Ballroom A1",
         "name":"When software meets hardware",
         "startTime":"2016-09-23T11:30:00+05:30"
      },
      {
         "category":"BELONG",
         "description":"The dream (or nightmare) of Artificial Intelligence, is to create a “Thinking Machine”, that replicates or even surpasses our brain’s ability along multiple dimensions. Such a machine could, for example, have a human-like conversation, solve complex problems, predict the next scene in a video, find a cure for cancer, prove Fermat’s last theorem, or even create art or poetry some day. Advances made in machine learning, natural language understanding, speech recognition and synthesis, computer vision, and deep learning have brought us to the brink of such a possibility.",
         "endTime":"2016-09-23T13:00:00+05:30",
         "location":"Grand Ballroom",
         "name":"Moneyball: The Magic of Big Data",
         "startTime":"2016-09-23T12:00:00+05:30"
      },
      {
         "category":"ASPIRE",
         "description":"CTOs will present on technology-led businesses and social disruption.",
         "endTime":"2016-09-23T11:35:00+05:30",
         "location":"Pre-function area",
         "name":"Transformers: Global Keynote",
         "startTime":"2016-09-23T10:35:00+05:30"
      }
   ]
}
```

