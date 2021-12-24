# Random Text Generator

This generates random text based on files.
The first file contains the frequencies of symbols, the second file contains the frequencies of word lengths.
A symbol can be any sequence of non-whitespace characters (including 1 character).

A symbol file contains two columns, where the symbol is in the first, and it's frequency is in the second:
```
a 122
b 45
c 78
hi 35
```
The frequency column contains the 'weight' of the symbol - how much more likely it is to be selected compared to the rest.

A length file follows the same rules as the symbol file, but the two columns must contain digits (first columng is length, second is its relative frequency).

There is 1 length file and 3 symbol files if the 'file' directory. 
The length frequencies in the length file are based off of [this study](http://norvig.com/mayzner.html) of word length frequencies in English text.
Here are some sample results using that length file with the symbol files:
`ascii.txt` - based off of [this study](http://www.fitaly.com/board/domper3/posts/136.html) of ascii character frequencies.
```
E.xhf-i rds xtr iiaR4ha *f dicrihe e fli itm shrttsntoi aw m.baeudya eb n2wioH nll4o 'thr oloeri eruoa pJXnt dh0rNraa,ttft ,nn locsins BoS h"n o-e tdn r,irwe-iy n a iitd cHb te tmpcuct 1ba rsvbe ontfete ecieo ao?oto ko. eo ncus0n hsnp0 ongsrde nm -eA tWpuo eae hwd oee uunlofn) e,ahst oab slhuk(nrj- on2Ht rnoR7m nthos-J0 de oghe s,ia no iehLees- eneha opo Cwh,i Wae, yn awreeN ox oa IbeoosC os en inoYmt l- nil lcoo ari,t uhaue ies0r ait-rvtr -mprw o0btet rl B2 doe: e-dswe mSne-na sta)taawdslit htaml.o yb(p smy -Asa ccB Git rfeoefIo mk erctDnese- ket iwe an ohcrnc s-ec1 eRo6sski2 l'l, eu9cud6m oG vnk rata yal en siwet teoht vi cp ka .0hbrrodduht( tMNa4 lasz icbhse rgehonswksd Ftlewl nivirefsn en.- ywonoau. chrn ee oehn wn <ben e ro( paswr lcaat iA yebEoYA-nNE ed m.mr mEt itat dlarh5 oe bea otoid ou wfs.d:e6rns irot rr sroor Uo pk 
```

`letters.txt` - this only contains lower case letters, with the same frequency as they appear in English [source of frequencies](http://norvig.com/mayzner.html)
```
ktfdytleie odc tr okesey yt tl her ssneuhote ea uooe monsr ti dh enxreoitah urnnd yys cev ecstori a yt uatenwortt feen tu re naie ant jiyh irdr vhodaee xecs efe andcy pmbivy dfcryrcde nrnttrsvi ro hpht tfr atetcseip asnhtan uraiiaotf aw rleeau dh raneh onvnf nnw isr nwi ce iowutegtg noaeh rcamvlnai se heraeae te tm tjr ta rneiwreei cxva roenei oe idsniatccnos ere eoavno edo hentebi ar gfegonsbrl ttoel gna rta atirut not meee dua duaerteasr oufnda ene tirt uamd mei trv soa le aahcwpa euc mliojnfe rhe evel ora os dfrug tyasf sr aoo tsa hgi htsei saedsatif adocsertot uuo nohnemteteii igivwtcwdeawa otsur hne ergtlo sheulepa fcdhffodaah ntasonhyyrb ophtebuf cpr esgiyab ncf yh ei ies ea srtelr ocei ota la oehoewaee dp eire deouietc lcp rs ars neh oinn amr eeoceietoa ppvbs fbasyelnsrol thn arn pd etiscs tuml tee rhi hemghdsr aaf iy e ria xel wa
```

`twoletters.txt` - frequencies of the most common two-letter sequences in English. The results are readable and look like a foreign language [source of frequencies](http://norvig.com/mayzner.html)
```
isteheeren inio anng ofer an ursehe ored arouri heerther ndis maanerofes thes dehean omorth ononto neco asbe redeasth ngiten erinbent ngtied tese llroli atis edbenethveth heorhete orleenri oric inhe islees redeasngit roheente inin ngto edar reheioou iodeouarin rolint toan ceng hitiar erle thatre math ioofndlene le erenlite ma urofve onchinteheedom sese co ertiat ti erre ensihe anin icon thneesasor chbe erhe heal oron ntis lein ll stenrial asnd anco omvebe maer it icrothse at reicin liheng asorstin atthre eshi albe sehe asar intihehest ro edenthhi eare lireis lehaoncoofalon chitstit atra ininceco on hi inhangrahero omri stininhi th erngtier thas esth edng li arat enesmero anng itreanof hadeon raal er de nd riatat iollnt eris edngatri handnt arhi in rengse estiherebe llis dehe ngor hira seenntan ve deof heic in thoninon beonse ha erhe tide or nt atth alanth isretehe rahe on onanri ones cebeerntsiic heom maanou thntsein onst of edveli 
```

***
There are two source files: `Main.java` and `Generator.java`.
The `Generator` is responsible for loading the files and creating the randomized text. 
You can edit the input symbol and length file in `Main.java`.

`compile` contains the command to compile the program (which is just compiling two files).
`run` contains the command to run the program.
`output.txt` - contains the output text (which is also printed out to stdout).