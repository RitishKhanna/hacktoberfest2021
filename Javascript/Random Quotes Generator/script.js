function randomQuote() {
  $.ajax({
      url: "https://api.forismatic.com/api/1.0/?method=getQuote&format=jsonp&lang=en&jsonp=?",
      dataType: "json",
      success: function( response ) {
          $("#quote").text(response.quoteText);
	  (response.quoteAuthor).trim()==""?"Anonymous":($("#author").text("- "+response.quoteAuthor));
      }
  });
}