[![Java CI with Maven](https://github.com/darkway-s/SE-Group10/actions/workflows/maven.yml/badge.svg)](https://github.com/darkway-s/SE-Group10/actions/workflows/maven.yml)
# SE-Group10 Decide
This project is using the java maven build tool to have a neat way of structuring everything and automate testing. The program is a hypothetical anti-ballistic missile system. The system returns Yes or No based on 15 requirements. 

## Strucute and implementation
All classes are implemented in [/src/test/java/com/group/decide](/src/test/java/com/group/decide). 
A full class diagram can be found [here](https://viewer.diagrams.net/?tags=%7B%7D&highlight=0000ff&edit=_blank&layers=1&nav=1&title=decide#R7V1bd9o6Fv41rJU%2BlGX5Co%2BEJG3mhJYTkvbMvDm2Ap4ai2ObBvrrR7Il3yRjQxBwOs7qSrGQZFv707582lJ62ni5%2BRTaq8UEudDvqYq76Wk3PVVVgTXA%2F5GSLS0xAEhL5qHnpmWFgpn3C9JChZauPRdGpYoxQn7srcqFDgoC6MSlMjsM0Vu52ivyy3dd2XPIFcwc2%2BdLv3tuvEhLB6qVl3%2BG3nzB7gzMYfrN0maV6ZtEC9tFb4Ui7banjUOE4vTTcjOGPhk9Ni7f77ff%2FYcf5qd%2F%2FRn9bT9f%2F%2FH05dvHtLO7fZpkrxDCID64a2f096%2FJ59nC%2B8%2F0j6%2FL6Wbgr68%2Fakba90%2FbX9MBm9hx6G16qunje10%2F4Q9z8oGOQbxlAxu9eUvfDvDV9SsK4hn9BuBr2%2FfmAf7s4OeFIS74CcPYwzIZ0S9itMKlzsLz3Qd7i9bkraLYdn6wq%2BsFCr1fuFvbp33ir8OYwktTSjVmpCUuJqUhjHCdKRsqUCma2JtSxQc7immBg3zfXkXeS%2FYaSzuce8E1imO0pJXoaOHXgZsKvhqEAzLE4LkG0RLG4Ra3Y72oA4oyOs8%2BqgM6895y1KoWrbQoInao09lCZ8o86z1HA%2F5AAbEPOEwOHD0VD4GSzsoRaY%2FfWcXVtM0oGZ3rZCb7Nd9WEITHME4kG6IfcIx8hKFyE6AUUp7vV4oYqnz4GtdiKlrZjhfMH5I6N3pe8khHjBQh3PbVT%2BbywnNdGBA8oNiO7VT4RNIrhJ8%2BGVHjGv%2FDAz9W%2BkbPwA8%2Bxtcgv8b%2FSPUwHqMAv4vtJTiAGFlvMIrbgmbH9ORRQ0GiKe0goktDiCVASEXKvpdIL5UyU8HgIBEvsbB8mMv0iYj85iPg5K7xctcEMvbtF%2BhPUeTFHiL9h2ndiuzPJl5LbyfegSzpDmrmf2oiripqYFyd%2Bx841dCyYVqU3JYW8uYolUzym7%2FPHMaP6I3cp%2FAwOzsS9ICxeYUf6x09fCNvUHqK7GWbe632F7XrLxu7gwYuRjMsoWB%2BRR8rvSpV6%2FS5tAk%2FUFuafKBKmvLDISdV6GJ%2Fml7iQVmgOQps%2FzYvxUO9Dlzo0oHO6zygRD8T9fxfGMdb6r3Z6xgR%2Fy1eMt8Obrz4L6LJlb6isIJ%2Fk%2F76JABJr2%2BY55ZcbNlFgF%2F7r6TqcGixAto27YsU5I2Tq1LrKQw9PHrEUaWF7ihMJhlDKi6588hAZvevtkm8U9bK8e0o8hxWTJuCDDlkRA9wHrFU0Dp04C58UfHh22L1cwAQQ%2Bjbsfez%2FHjHNyxDgWFJ9RT7HwbrJQztxDDnGrGqGcdp0Ii1yg61dMZARf%2F9AhVTbRGogKFIaymyHBVdqXFURl9ueMP89fGRK%2Fvy9el5dnvTGbpjGbrhTkOn84GLEDKmIgsxoAtc5IkXKC3lK00h6Jx4vzE7cbm0FtY4v5u14Ggt3WzJWQBd2tznOc%2FUCPgwmJNnyiKpTu3vqRfSeVerF1SznexVWXyVLmI0O7V%2FJPEaLae2NK0vYiPJxE51%2FxU3v1swVnVN27BTQl4q5XA8HDBvzsYBdbzPZelFo%2BVSD%2BOHjj5zDH7mTJHIBHbe0VFjaaPiHVlDgeOsiAIjWTrUqOP8N%2FULfttute8oWiKdhft4T0JsaLK8J0NE23Xe05HEKwiMhOKVNfOHFifMU1D%2FOdme0%2BY5334K0hxkeUlNrHlqf9%2FBmtOm1LbmUbIF%2BsAqmwJzgBWOWe4qfZXcMlNx4wG0t4VqFND199PYTC7crNhhmxaGXkFc%2BhQ5%2FrLxORySJm%2BMHux14CzuiYvhwBV2zfE8dZMZHU3swJ5jz6PzWST6LBYj8RkQDIHe0sBJCR1TZJfSTKQMGzhwSgnAxFUpk4HXCPnQDoRRV%2BfE7Gnl0jm7jxMjRIs0CojFVZ0TI0O8AgpIrAxk6QJLtLBDdEGz4RDzQ0VtMFZ7I6X9bzyYdpIkQGmiKbvm%2BZeH%2B7FyxRf38Y%2BoLtArlTs1dVwctzVqA1k4Biwz%2BzyZOOUkHNXotcrBIfk7WcpN2lSxjN4BOTilfBqK0mIyTSVPpy50KGtwtYJ%2BPH1eX19Vx%2BGmCv5GSX5OEH5YZsvog8Yp50raASwd%2FDyIJCohxyRoB0ilr6ulpLAEoQdlhR0VkSKc8Vi9GOTVKcvTAM%2FiF%2B1uoOO58AIDvvPtTGmt2FzzxTRMmSGiWWW1RekgjFA4iTW1RKx25%2FS3dZbSGbjPNhSxeGVJty7%2Bn%2BBBqDjKe%2FrMxflSN8P%2BD73nJkAIMkJFgNBlrWeyhdLieiYLvi7JXPx%2B%2FCDQhlWmmNFzRTRYhoATkEYQDrQ6UuD2y6enz2l07qI1GbFqtP04url%2FnoGddW6ns%2FuHr1921hk93o7qeqlG%2BV00v6c%2BqluY2bFyKkKgJYt0HPD5qJ3%2FcTTxCtONRfJVpSmYup3SmdUpkYtMAST83oe6%2BV4IghvtUCbxxBrUTk8iIhJiR6n54QPSeq0iT3rquaUHmGd6JmajdyjXpqi9MtmW74A7cMPbi4%2BIB7I3jTZwoDjafBkYukFu4trRIhmtkyzpK1S%2FXji1ATTtnMg7jOVV%2BrpexN1BdFoJDntya8JdmcfA6OXAEqhn3aCZPWgxgMK39pZeYIfb54CoCew0pPv5L5CH%2B%2F0CK9OsJF5oglxR3RCutUoznEpdYLWqBUvqAZUPGeoSMI7oLNO5u08wJISNtAwMoHTRkEwBC3IwhAKWRccCpW6D3fR5MhFnWTyMJyLFUNzfT1UDqT2efGuRx8WnU6B4QcyU8roOnPRkASWAkLhSZAcM%2FoVR46yxgYXpw3ba5%2Fjg5KlhITilUcNA4fe63GFD5Wd2KgVV59Scw6kRJt4ID5OQlkGWHVPBqa9XAUxa5ZN2WmRvLbL3VhghSiT6MN1eGJkCFuWRnvIAiUy9cErg7vlbjQ8zfW7jlbC6Qn%2Bn0YNZ2NHI95%2FCNUz2AUdsv27e8B0eD361bsfvqQDO%2B0FCgBvS%2FCDAe%2BnJrp%2FO8TnFMrmuVpbJhVt%2Fhcvk8ugcULeMxaYUUTXJPq8HL4qZ0qJ7xTpn51BVAXafCtl29VqaszM8Typ6czJtto7BlsKytQzFtHo7FzMEZzj2mtn%2F3Zq07U7To28g%2FQgq2zNBFQs1O0fzntjBbJUdp%2BlCxbt3nOZLrOwBwe4Np9mevgPr0%2FeQujsVgO70a5l6TxADnDgvAIiYgNToud7P3OQl3GbBd6rGBx%2Fy003vSg0LfSlM%2Brj07zX5mxLXCQ6yq%2FLtbNdN7niVSIvuL0PFe72E1ftU7y621L9L2kkTvKyW8NLkpZ0onAzOtvjfdu2%2FV0o4UZs3d53%2FeAfQdptL3QEdJ1pzZz2Lkpa7oOwUQZlSPY%2FJFARlqnCNXVruMmBOBReUBevltBCXiU5mKsZt5eC%2BWrFuqzK%2F%2B7j1Sl2lYVt6TExANX7sws597WNdMLLjsE4R9KUlTWdBTOdfSxGwKG1aKGGJibe1mQIVw3flBas1dXPvycdZHEJ7edXT7j7sk0DdJPpL9GObxCjInz61GM9zdJgwf7rJkW1Idd4%2FaZRPPD1xqvN7M5jFjAqfb1gNhI7EDZl6NQeAqvk6rodrwJ5MLtuj8cbn4qO1vq6XzuMAfTA8ebr24YdznD9jm9GKF5%2BwzQ79%2FIehUy%2BjUzG7zQR7Kv5%2FAjZb8ORCfVFAWhmq%2B1jjOsmVQCPyJXafMSNdvFqNXS%2B4eSIvj5W90%2FwbVfNvWkp%2FAIb5T7nHxgWmOuPd0G%2BNk3E8q85T%2FITTsJck4A9eolUiauU9RQnN4TGCg2yMgNgdUpI%2FbMZ4eS%2FnP9p13Obe2xaB0b4ESfNSwNvCi%2BEMh8fknm%2BhveJmb6tY6AD%2BzqgsMpKDZ0TYKjL%2BqmAKyWP8hX%2Bo7LiasOY8qV2xTX7ElqKWLflwwJbVG2x52ctssuGHLb6%2FT52yv%2FjVbC31GpSdSvFWOWh12B8Oj6B49%2BtXtuIV%2FAW2GsVb1p%2FrKNGeXoB9usAhaYvoVaxIO32oahWRi5bUteNQRfgyRGShOkcJftfFBLmQ1Pgf).

The parameters for the CMV are implemented as methods in the ConditionsMetVector class.  



### Continuous integration
GitHub Actions are integrated to automatically build and test our code when a PR is created. This is a good way to avoid any faulty code being merged with the main branch. 

Our implementation of the CI is based on GitHubs maven template and can be found in the [.github/workflows](.github/workflows) folder.

### Git workflow
Some standards are set to make everything clear.  
Branch-naming: issue/nr

## How to run
Compile all files and run with:
```
$ mvn exec:java -D"exec.mainClass"="com.group10.decide.LaunchInterceptorProgram" 
```

## How to run tests
This maven project is comes with a test suit that can be tested with the following command:
```
$ mvn test
```
All unit tests in the suite are located in the [/src/test/java/com/group/decide](/src/test/java/com/group/decide) and each java class has their own test class. 

## Statement of contribution
We decided that the LIC requirements was a good way to split the work between us. Therefore, we assigned 3 requirements each with approximate the same level of difficulty. 

On top of that, we also needed some other part for the program to work well which are listed bellow. 
| Name | Tasks |
| --- | --- |
| Amanda |  |
| Chiyi | Implement LIC 0, 5, 11 and their unit tests.<br />Implement the input functions of LIC parameter class. <br />Implement the Implemented Launch Interceptor Program.<br />Refractor the Condition Met Vector class. <br />Refractor the unit tests of all LICs to make them uniform. <br />Fix some edge test errors of LICs. |
| Ludwig | |
| Sebastian | |
| Şefik | |

## Essence
We have had a discussion of our state of work. The conclusion of our discussion can be found [here.](https://docs.google.com/document/d/1F2XvOlAA5KcxmcbASf5P0KabFuRd7MKCWuzxflHKIb8/edit)
