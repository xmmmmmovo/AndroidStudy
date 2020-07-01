import 'package:flutter/material.dart';
import 'package:newsflutter/components/app.dart';
import 'package:newsflutter/utils/utils.dart';
import 'package:newsflutter/values/values.dart';

/// app主体框架
class ApplicationPage extends StatefulWidget {
  @override
  _ApplicationPageState createState() => _ApplicationPageState();
}

class _ApplicationPageState extends State<ApplicationPage>
    with SingleTickerProviderStateMixin {
  int _pageNumber = 0;

  final _tabTitles = ['Welcome', 'Category', 'Bookmarks', 'Account'];
  PageController _pageController;
  final _bottomTabs = <BottomNavigationBarItem>[
    new BottomNavigationBarItem(
      icon: Icon(
        Iconfont.home,
        color: tabBarElement,
      ),
      activeIcon: Icon(
        Iconfont.home,
        color: secondaryElementText,
      ),
      title: Text('main'),
      backgroundColor: primaryBackground,
    ),
    new BottomNavigationBarItem(
      icon: Icon(
        Iconfont.grid,
        color: tabBarElement,
      ),
      activeIcon: Icon(
        Iconfont.grid,
        color: secondaryElementText,
      ),
      title: Text('category'),
      backgroundColor: primaryBackground,
    ),
    new BottomNavigationBarItem(
      icon: Icon(
        Iconfont.tag,
        color: tabBarElement,
      ),
      activeIcon: Icon(
        Iconfont.tag,
        color: secondaryElementText,
      ),
      title: Text('tag'),
      backgroundColor: primaryBackground,
    ),
    new BottomNavigationBarItem(
      icon: Icon(
        Iconfont.me,
        color: tabBarElement,
      ),
      activeIcon: Icon(
        Iconfont.me,
        color: secondaryElementText,
      ),
      title: Text('my'),
      backgroundColor: primaryBackground,
    ),
  ];

  void _handleNavBarTap(int index) {
    _pageController.animateToPage(index,
        duration: const Duration(milliseconds: 200), curve: Curves.ease);
  }

  // tab栏页码切换
  void _handlePageChanged(int page) {
    setState(() {
      this._pageNumber = page;
    });
  }

  @override
  void initState() {
    super.initState();
    _pageController = new PageController(initialPage: this._pageNumber);
  }

  /// 释放资源
  @override
  void dispose() {
    _pageController.dispose();
    super.dispose();
  }

  Widget _buildAppBar() {
    return transparentAppBar(
        context: context,
        title: Text(
          _tabTitles[_pageNumber],
          style: TextStyle(
            color: primaryText,
            fontFamily: 'Montserrat',
            fontSize: duSetFontSize(18.0),
            fontWeight: FontWeight.w600,
          ),
        ),
        leading: IconButton(
          icon: Icon(
            Icons.arrow_back,
            color: primaryText,
          ),
          onPressed: () {
            Navigator.pop(context);
          },
        ),
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.search,
              color: primaryText,
            ),
            onPressed: () {},
          )
        ]);
  }
  // 内容页
  Widget _buildPageView() {
    return PageView(
      physics: NeverScrollableScrollPhysics(),
      children: <Widget>[
      ],
      controller: _pageController,
      onPageChanged: _handlePageChanged,
    );
  }

  // 底部导航
  Widget _buildBottomNavigationBar() {
    return BottomNavigationBar(
      items: _bottomTabs,
      currentIndex: _pageNumber,
      // fixedColor: AppColors.primaryElement,
      type: BottomNavigationBarType.fixed,
      onTap: _handleNavBarTap,
      showSelectedLabels: false,
      showUnselectedLabels: false,
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: _buildAppBar(),
      body: _buildPageView(),
      bottomNavigationBar: _buildBottomNavigationBar(),
    );
  }
}
