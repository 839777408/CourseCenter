/*
 Navicat Premium Data Transfer

 Source Server         : localhost_3306
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : course_center

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 21/03/2021 23:42:36
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for course
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course`  (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `img_url` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `teacher_no` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `create_time` date NOT NULL,
  `intro` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `activity` int(10) NOT NULL,
  `notice` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 44 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES (28, '嵌入式操作系统（Linux篇）', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp10.jpg', '20100315', '2021-02-28', '嵌入式操作系统课程是物联网工程专业、嵌入式应用专业的一门核心的专业课。本课程全面、系统地介绍嵌入式操作系统的知识，包括操作系统的工作原理，配置与维护嵌入式操作系统以及基于嵌入式操作系统的程序开发。使得学生在毕业后能直接从事嵌入式相关岗位的工作。\n        嵌入式操作系统（Embedded Operation System，EOS）是一种用途广泛的系统软件，过去它主要应用于工业控制和国防系统领域。EOS负责嵌入系统的全部软、硬件资源的分配、任务调度，控制、协调并发活动。它必须体现其所在系统的特征，能够通过装卸某些模块来达到系统所要求的功能。\n\n随着Internet技术的发展、信息家电的普及应用及EOS的微型化和专业化，EOS开始从单一的弱功能向高专业化的强功能方向发展。嵌入式操作系统在系统实时高效性、硬件的相关依赖性、软件固化以及应用的专用性等方面具有较为突出的特点。EOS是相对于一般操作系统而言的，它除具有了一般操作系统最基本的功能，还有以下功能：如任务调度、同步机制、中断处理、文件处理等', 1, 'EOS');
INSERT INTO `course` VALUES (29, 'JAVA语言程序设计', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp1.jpg', '20100315', '2021-02-28', '介绍电子信息类专业选修I模块的《JAVA语言程序设计》课程基本情况、大纲以及教学计划。', 1, '');
INSERT INTO `course` VALUES (30, '计算机网络', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp6.jpg', '20100315', '2021-02-28', '课 程 简 介\n\n课程地位与作用： \n\n《计算机网络》课程是我院网络工程专业、计算机科学与技术专业、信息管理与信息系统、物联网工程、通信工程以及电子信息工程专业等6个信息类本科生开设的一门必修课，是此类专业的专业基础课和主干课程之一，它是“路由与交换技术”、“无线网络技术”、“无线传感网与RFID技术”、“网络工程与组网技术”等后续专业课程的先导课。\n\n课程研究对象与研究内容：\n\n计算机网络是一门综合性交叉学科，综合了计算机技术和通信技术两个学科的概念和方法，需要软件和硬件的结合，需要计算机技术和通信技术的结合，需要理论和应用的结合，需要课堂和特殊实验环境的结合，需要教学与市场的密切联系。本课程涉及的知识面较广，知识点分散，在教与学的过程中，把握重点都是至关重要的。计算机网络的研究对象是计算机网络的体系结构，研究的主要内容是以TCP/IP体系为核心的各层协议的基本概念、原理和方法，包括物理层、数据链路层、介质访问子层、网络层、传输层和应用层等内容。\n\n课程目标：\n\n通过本课程的学习，使学生掌握计算机网络体系的基本概念、基本知识、基本原理及基本应用，培养学生的创新意识和创新能力，使学生获得解决实际网络工程的基本训练。通过本课程的学习，学生应该掌握计算机网络的分层体系结构以及各种典型网络协议的工作机理，初步掌握计算机网络相关软硬件知识；熟悉计算机网络中广泛使用的工具，了解各种最新的网络知识，跟踪网络研究与发展的新方向，为后续课程的学习以及今后从事计算机网络方面的工作打下良好的基础，培养学生的逻辑思维能力和抽象概括能力。 \n\n课程特点： \n\n(1) 计算机网络的概念较多，而且许多内容都比较抽象，因此要强调网络基本概念和基本原理，不要过多地介绍具体的网络专用设备。\n\n(2) 计算机网络技术的发展迅速，不断出现新的概念和技术，因此应尽可能地讲授较新的内容，使学生学习的内容能适应网络发展的现状。 \n\n(3) 本课程实践性和工程性和较强，在教学中要理论联系实际，重视实验环节。通过实践加强对计算机网络的认识和理解。\n\n教学要求层次：　\n\n(1)掌握：要求学生能够全面、深入理解和熟练掌握所学内容，并能够用其分析、初步设计和解答与网络应用相关的问题，能够举一反三。 \n\n(2)理解：要求学生对这门学科涉及到的概念、原理、方法的说明和解释，能提示所涉及到的教学现象演变过程的特征、形成原因以及教学要素之间的相互关系。\n\n(3) 了解：要求学生能够一般地了解的所学内容。\n\n主要内容： \n\n《计算机网络》课程全面系统地讲述了计算机网络的发展、定义、组成以及网络协议和网络结构，物理层，数据链路层，局域网技术，广域网技术，网络互连，传输层，应用层协议，网络安全和当前计算机网络的若干热门课题等内容。\n\n教学方式：\n\n计算机网络课程涉及面广，网络新技术不断出现，为了更好地实现教学目标，建议采用如下的教学方法进行配合教学。\n\n(1) 以文字教材为学习的主要媒体，着重反映课程知识的系统性和完整性，并在形式上要便于自学。 \n\n(2) 以任务驱动的方法带动教学，采取课堂讲授、实际操作、现场参观、课后自学、课堂讨论等形式。\n\n(3) 利用仿真软件、多媒体课件、动画演示以及教学网站等优势，仿真软件、多媒体课件和动画演示作为新的网络教学媒体，可以作为学生上网在线自学使用，也可以用于教师课堂教学。 \n\n课程总学时数：\n\n教学总学时56学时，其中授课44学时，实验12学时。', 1, '全面系统地讲述了计算机网络的发展');
INSERT INTO `course` VALUES (31, '网络安全技术', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp13.jpg', '20100315', '2021-02-28', '网络安全是一门涉及计算机科学、网络技术、通信技术、密码技术、信息安全技术、应用数学、数论、信息论等多种学科的综合性科学。从广义性来说，凡事涉及到网络上信息的保密性、完整性、真实性、可用性和可控性的相关技术和理论都是网络安全的研究领域。\n\n我院从2004年就开设了《网络安全技术》课程，当时授课对象仅为网络工程专业学生。随着学院建设的发展，招生人数逐年增加，该课程也在不断发展壮大。目前，《网络安全技术》主要授课对象为计算机科学与技术、网络工程、物联网技术等专业本科生。\n\n《网络安全技术》课程在2016年获得校级精品资源共享课建设项目立项，经过团队成员的不断努力，建立了规范的精品课程网站，包含教学大纲、教案、教学日历、教学录像等模块，目前网站内容在不断建设完善中。', 1, '课程在2016年获得校级精品资源共享课建设项目立项');
INSERT INTO `course` VALUES (32, '无线传感网与RFID技术', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp13.jpg', '20100315', '2021-02-28', '《无线传感网与RFID技术》是物联网工程专业的专业必修课，它是根据国家培养物联网工程人才的需要而设置的。无线传感网和RFID技术两项技术都是物联网的核心技术。\n\n本课程无线传感网部分主要讲授无线传感器网络的发展、构成、体系结构、通信协议、支撑技术和应用。课程的重点放在无线传感器网络的组网方面，包括不同层上的协议(如物理层和硬件、MAC、链路层、网络层)，以及它们是如何根据不同的应用需求提出的。\n\n本课程RFID技术部分的内容涉及电感耦合方式的射频前端原理、功率放大电路、RFID中常用的编码解码和调制解调电路、数据校验和防碰撞算法、RFID系统数据传输的安全性、RFID的ISO/IEC标准、以及不同频段（125kHz 、13.56MHz 、微波频段） RFID 技术、EPC与物联网、RFID在不同领域的应用等。\n\n通过本课程的学习，使学生掌握无线传感器网络的基本理论和基本知识，培养学生分析问题和解决问题的能力，为以后更深层次的理论研究和应用实践打下坚实的基础；使学生掌握射频识别（RFID）的基本理论和基本知识，培养学生分析问题和解决问题的能力，并使其具有物联网应用系统的分析能力和初步设计能力。\n\n具体来说，通过本课程，学生将会：\n\n1.了解无线传感器网络的技术体系，发展现状；\n\n2.了解无线传感器网络节点体系结构以及物理层设计；\n\n3.掌握基本的无线传感器网络MAC、链路层、路由协议、拓扑控制协议以及其特点；\n\n4.掌握无线传感器网络定位技术、时间同步技术与数据处理技术；\n\n5.掌握无线传感器网络的相关通信标准；\n\n6.了解无线传感器网络操作系统和开发环境；\n\n7.了解RFID技术的基本概念、产生的背景和意义及其基本理论和应用实践的最新成果；\n\n8.掌握RFID技术基本原理、标准体系、应用系统的架构；\n\n9.通过了解和掌握所学知识，使学生理解射频识别（RFID）的基本工作原理，为从事物联网的应用研究奠定良好的基础。', 1, '财务室');
INSERT INTO `course` VALUES (33, '算法分析与设计', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp12.jpg', '20100315', '2021-02-28', '计算机、电子信息专业核心课程，以算法合集策略为知识单元，系统介绍计算机算法的设计方法与分析技巧。主要内容包括：算法概述、递归与分治策略、动态规划、贪心算法、回溯法、分支限界法、随机化算法、线性规划与网络流、NP完全性理论与近似算法等。', 1, '');
INSERT INTO `course` VALUES (34, '数据库原理及应用', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp9.jpg', '20100315', '2021-02-28', '物质、信息、能源已经成为人类生存和发展的重要保障。数据库的应用广度深度及建设规模已经成为衡量一个国家信息化程度的一项重要标志。 \n\n数据库技术是计算机学科的一个重要分支，反映了数据管理的最新技术。数据库技术与计算机网络、人工智能一起被称为计算机三大热门技术，是现代信息化管理的重要工具。学习本课程具有非常重要的实际意义。\n\n数据库技术已经成为各类计算机信息系统的核心技术和重要基础。现代信息社会，数据已经成为重要的资源和开发利用的新“能源”，数据库技术已应用到各行各业各个层面和各种实际业务的数据管理。\n\n在现代信息化社会，所有与数据信息有关的业务及应用系统都需要数据库技术的支持。本课程是计算机类专业、电子、通信、电气、管理和商务等学科专业开设的一门主要专业基础课、必修课，很多院校已经在所有专业开设。', 1, '数据库技术是计算机学科的一个重要分支');
INSERT INTO `course` VALUES (35, '汇编语言程序设计', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp3.jpg', '20100315', '2021-02-28', '汇编语言是一门计算机学科基础选修课，学习它是认识计算机系统的重要途径。它是一种面向机器的程序设计语言，是最接近计算机核心的编码语言，直接描述机器指令，比机器指令容易记忆和理解。 学生通过先修课《计算机导论》、《计算机组成原理》、《c语言程序设计》等课程的学习，对计算机的基本硬件原理和工作过程详细掌握', 1, '直接描述机器指令，比机器指令容易记忆和理解。');
INSERT INTO `course` VALUES (36, '数据库原理及应用', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp1.jpg', '20100315', '2021-02-28', '本课程是计算机类相关专业的一门专业基础课程，主要系统讲授数据库系统的基础理论、基本技术和基本方法。内容包括：数据库的体系结构、数据模型和关系运算等基本概念，并结合当前流行的大型关系数据库管理系统SQL SERVER平台，通过实例讲解和演示数据库的标准语言SQL、数据库的安全性和完整性控制、事务管理与恢复技术,以及关系规范化理论和数据库的设计，为进一步从事数据库的应用开发和研究奠定坚实的基础。', 1, '主要系统讲授数据库系统的基础理论、基本技术和基本方法。');
INSERT INTO `course` VALUES (40, 'Web应用项目开发', 'https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp12.jpg', '20100315', '2021-02-28', '《卓越工程师培养计划\"十二五\"规划教材:Web应用项目开发》重点阐述Web应用项目开发的基本过程和实际工作中可能遇到的问题及解决方法，以实用化的“毕业工作管理系统”为贯穿全书的案例，遵循软件企业从签订合同到系统部署的工作流程，系统介绍从立项、需求分析、系统设计、交互设计、编码、测试到部署的Web应用项目开发的全过程。\n\n《Web应用程序开发》以任务为导向开展，适合项目化教学需要，贴近实际开发流程，注重实践理论的结合，涵盖ASP.NET的主要常用技术，覆盖Web开发中的典型功能模块，免费赠送教学PPT课件、课后习题答案。\n主要内容包括基于ASP.NETt的开发系统环境搭建、Web系统开发流程、三层架构的搭建、页面框架的搭建、页面数据的显示、页面数据的更新、查询的实现、常用页面控件的使用、常用web系统功能的实现、系统的配置和部署以及基于web的系统测试等。 以实际应用为出发点，归纳并选取了web应用程序开发中具有代表性的知识和技能逐层深入进行讲解。本书适用于三年制高职高专、成人高校以及社会计算机培训学校等计算机及相关专业的学生使用，也可作为web应用程序开发等人员的参考用书。', 1, '系统介绍从立项、需求分析、系统设计、交互设计、编码、测试到部署的Web应用项目开发的全过程。');

-- ----------------------------
-- Table structure for means
-- ----------------------------
DROP TABLE IF EXISTS `means`;
CREATE TABLE `means`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `file_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `course_id` int(11) NOT NULL,
  `upload_Time` datetime NOT NULL,
  `size` double(11, 2) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 18 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of means
-- ----------------------------
INSERT INTO `means` VALUES (7, '许卓楠-Java开发工程师.docx', 40, '2021-03-11 00:00:56', 0.08);
INSERT INTO `means` VALUES (9, '许卓楠-Java开发工程师 - 副本.docx', 40, '2021-03-11 20:19:53', 0.09);
INSERT INTO `means` VALUES (10, 'SpringBoot整合Vue的小案例.md', 40, '2021-03-11 20:21:40', 0.01);
INSERT INTO `means` VALUES (12, 'Vue-CLI相关.md', 40, '2021-03-11 20:23:28', 0.01);
INSERT INTO `means` VALUES (13, 'Git.md', 40, '2021-03-11 20:43:03', 0.01);
INSERT INTO `means` VALUES (14, 'Mybatis问题解决.md', 40, '2021-03-11 20:44:45', 0.01);
INSERT INTO `means` VALUES (17, 'Vue的模块化开发.md', 40, '2021-03-11 21:43:52', 0.01);

-- ----------------------------
-- Table structure for note
-- ----------------------------
DROP TABLE IF EXISTS `note`;
CREATE TABLE `note`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `content` text CHARACTER SET utf8 COLLATE utf8_general_ci NULL,
  `create_time` datetime NOT NULL,
  `no` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 14 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of note
-- ----------------------------
INSERT INTO `note` VALUES (1, '111', '111', '2021-01-30 22:47:38', '201710214632');
INSERT INTO `note` VALUES (2, '带我去', '定位', '2021-01-31 13:42:26', '201710214632');
INSERT INTO `note` VALUES (3, '带娃', '当前', '2021-01-31 13:52:13', '201710214632');
INSERT INTO `note` VALUES (4, '我去', '翻墙', '2021-01-31 13:52:26', '201710214632');
INSERT INTO `note` VALUES (5, '改为', '发过去', '2021-01-31 13:52:47', '201710214633');
INSERT INTO `note` VALUES (6, '大青蛙', '废弃物', '2021-01-31 13:52:58', '201710214632');
INSERT INTO `note` VALUES (7, '15', '的', '2021-01-31 13:53:11', '201710214632');
INSERT INTO `note` VALUES (8, '1564', '噶婉儿', '2021-01-31 14:59:31', '201710214632');
INSERT INTO `note` VALUES (9, '图', '# 图\n\n## 基本概念\n\n图（Graph）是由顶点的**有穷非空**集合和顶点之间边的集合组成，通常表示为：G（V，E），其中，G表示一个图，V是图G中顶点的集合，E是图G中边的集合。\n\n线性表中我们把数据元素叫元素，树中将数据元素叫结点，**在图中的数据元素，我们则称之为顶点（Vertex）。**\n\n图中，任意两个顶点之间都可能有关系，顶点之间的逻辑关系用边来表示，**边集可以是空的**。\n\n---\n\n**无向边(Edge)**：若顶点V1到V2之间的边没有方向，则称这条边为无向边。（V1,V2）=（V2,V1）。\n\n**无向图(Undirected graphs)**：图中任意两个顶点之间的边都是无向边。\n\n**有向边**：若从顶点V1到V2的边有方向，则称这条边为有向边，也称**弧(Arc)**。用<V1,V2>表示，V1为弧尾(Tail)，V2为弧头(Head)。<V1，V2> ≠ <V2，V1>。\n\n**有向图(Directed graphs)**：图中任意两个顶点之间的边都是有向边。\n\n`注意：无向边用“（）”，而有向边用“< >”表示。`\n\n**权（Weight）**：与图的边或弧相关的数。\n\n**网（Network）**：带权的图。如下图，此图的权就是两地的距离。\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200829151206.png)\n\n在图中，若不存在顶点到其自身的边，且同一条边不重复出现，则称这样的图为**简单图**。下面两个就不是简单图。\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200829150555.png)\n\n在无向图中，如果任意两个顶点之间都存在边，则称该图为**无向完全图**。含有n个顶点的无向完全图有**n×(n-1)/2条边**。\n\n在有向图中，如果任意两个顶点之间都存在方向互为相反的两条弧，则称该图为**有向完全图**。含有n个顶点的有向完全图有**n×(n-1)**条边。\n\n---\n\n顶点v的**度**：与v相关联的边的数目；\n\n顶点v的**出度**：以v为**起点**有向边数；\n\n顶点v的**入度**：以v为**终点**有向边数。\n\n---\n\n在无向图G中，如果从顶点v到顶点v\'有路径，则称v和v\'是连通的。如果对于图中任意两个顶点Vi、Vj∈E，Vi和Vj都是连通的，则称G是**连通图**（Connected Graph）。无向图中的极大连通子图称为**连通分量**。\n\n在有向图G中，如果对于每一对Vi、Vj∈V、Vi≠Vj，从Vi到Vj和从Vj到Vi都存在路径，则称G是**强连通图**。有向图中的极大强连通子图称做有向图的**强连通分量**。\n\n**路径的长度**是路径上的边或弧的数目。\n\n第一个顶点到最后一个顶点相同的路径称为**回路或环**（Cycle）。除了第一个顶点和最后一个顶点之外，其余顶点不重复出现的回路，称为**简单回路或简单环**。两个图的粗线都构成环，左侧的环因第一个顶点和最后一个顶点都是B，且C、D、A没有重复出现，因此是一个简单环。而右侧的环，由于顶点C的重复，它就不是简单环了。\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200829152602.png)\n\n\n\n\n\n## 邻接矩阵\n\n图的邻接矩阵（Adjacency Matrix）存储方式是用两个数组来表示图。一个一维数组存储图中顶点信息，一个二维数组（称为邻接矩阵）存储图中的边或弧的信息。\n\n<img src=\"https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200816172623.png\" style=\"zoom: 67%;\" />\n\n​                                       <img src=\"https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200829154636.png\"  />\n​                                  ![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200829154701.png)\n\n## 邻接表\n\n我们把这种数组与链表相结合的存储方法称为邻接表（Adjacency List）。\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200816172207.png)\n\n## 边集数组\n\n边集数组是由两个一维数组构成。一个是存储顶点的信息；另一个是存储边的信息，这个边数组每个数据元素由一条边的起点下标（begin）、终点下标（end）和权（weight）组成。\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/微信截图_20200829155315.png)\n\n## 创建图的代码实现\n\n```java\npackage com.nanzx.graph;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\npublic class Graph {\n\n	private ArrayList<String> vertexList;// 顶点集合\n	private int[][] edges;// 图对应的邻接矩阵\n	private int numOfEdges;// 边的数目\n\n	public static void main(String[] args) {\n\n		String Vertexs[] = { \"A\", \"B\", \"C\", \"D\", \"E\" };\n\n		// 创建图对象\n		Graph graph = new Graph(Vertexs.length);\n		// 循环的添加顶点\n		for (String vertex : Vertexs) {\n			graph.insertVertex(vertex);\n		}\n\n		// 添加边\n		// A-B A-C B-C B-D B-E\n		graph.insertEdge(0, 1, 1);\n		graph.insertEdge(0, 2, 1);\n		graph.insertEdge(1, 2, 1);\n		graph.insertEdge(1, 3, 1);\n		graph.insertEdge(1, 4, 1);\n\n		// 显示一把邻结矩阵\n		graph.showGraph();\n	}\n\n	// 构造器\n	public Graph(int n) {\n		vertexList = new ArrayList<String>();\n		edges = new int[n][n];\n		numOfEdges = 0;\n	}\n\n	// 插入顶点\n	public void insertVertex(String vertex) {\n		vertexList.add(vertex);\n	}\n\n	// 添加边\n	public void insertEdge(int v1, int v2, int weight) {\n		edges[v1][v2] = weight;\n		edges[v2][v1] = weight;\n		numOfEdges++;\n	}\n\n	// 图中常用的方法\n	// 返回顶点的个数\n	public int getNumOfVertex() {\n		return vertexList.size();\n	}\n\n	// 显示图对应的矩阵\n	public void showGraph() {\n		// System.err.println(Arrays.deepToString(edges));\n		for (int[] e : edges) {\n			System.err.println(Arrays.toString(e));\n		}\n	}\n\n	// 得到边的数目\n	public int getNumOfEdges() {\n		return numOfEdges;\n	}\n\n	// 返回i(下标)对应的数据顶点 0->\"A\" 1->\"B\" 2->\"C\"\n	public String getValueByIndex(int i) {\n		return vertexList.get(i);\n	}\n\n	// 返回v1和v2的权值\n	public int getWeight(int v1, int v2) {\n		return edges[v1][v2];\n	}\n}\n\n```\n\n**运行结果：**\n\n[0, 1, 1, 0, 0]\n[1, 0, 1, 1, 1]\n[1, 1, 0, 0, 0]\n[0, 1, 0, 0, 0]\n[0, 1, 0, 0, 0]\n\n\n\n## 深度优先遍历(Depth First Search) \n\n**基本思想：**\n\n从初始访问结点出发，初始访问结点可能有多个邻接结点，深度优先遍历的策略就是首先访问第一个邻接结点，然后再以这个被访问的邻接结点作为初始结点，访问它的第一个邻接结点， 可以这样理解：**每次都在访问完当前结点后首先访问当前结点的第一个邻接结点。**\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/20200830021.jpg)\n\n```java\npackage com.nanzx.graph;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\n\npublic class Graph {\n\n	private ArrayList<String> vertexList;// 顶点集合\n	private int[][] edges;// 图对应的邻接矩阵\n	private boolean[] isVisited;// 记录某个顶点是否被访问\n\n	public static void main(String[] args) {\n\n		String Vertexs[] = { \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\" };\n\n		// 创建图对象\n		Graph graph = new Graph(Vertexs.length);\n		// 循环的添加顶点\n		for (String vertex : Vertexs) {\n			graph.insertVertex(vertex);\n		}\n		// 更新边的关系\n		graph.insertEdge(0, 1, 1);\n		graph.insertEdge(0, 2, 1);\n		graph.insertEdge(1, 3, 1);\n		graph.insertEdge(1, 4, 1);\n		graph.insertEdge(3, 7, 1);\n		graph.insertEdge(4, 7, 1);\n		graph.insertEdge(2, 5, 1);\n		graph.insertEdge(2, 6, 1);\n		graph.insertEdge(5, 6, 1);\n\n		// 显示一把邻结矩阵\n		graph.showGraph();\n\n		System.out.println(\"深度遍历\");\n		graph.dfs(0); // [1->2->4->8->5->3->6->7]\n	}\n\n	// 构造器\n	public Graph(int n) {\n		vertexList = new ArrayList<String>();\n		edges = new int[n][n];\n		isVisited = new boolean[n];\n	}\n\n	// 插入顶点\n	public void insertVertex(String vertex) {\n		vertexList.add(vertex);\n	}\n\n	// 添加边\n	public void insertEdge(int v1, int v2, int weight) {\n		edges[v1][v2] = weight;\n		edges[v2][v1] = weight;\n	}\n\n	// 深度优先遍历\n	public void dfs(int i) {\n		System.out.print(vertexList.get(i) + \"->\");\n		isVisited[i] = true;\n		for (int j = i + 1; j < vertexList.size(); j++) {\n			if (edges[i][j] > 0 && isVisited[j] == false) {\n				dfs(j);\n			}\n		}\n	}\n\n	// 显示图对应的矩阵\n	public void showGraph() {\n		for (int[] e : edges) {\n			System.out.println(Arrays.toString(e));\n		}\n	}\n}\n```\n\n**运行结果：**\n\n[0, 1, 1, 0, 0, 0, 0, 0]\n[1, 0, 0, 1, 1, 0, 0, 0]\n[1, 0, 0, 0, 0, 1, 1, 0]\n[0, 1, 0, 0, 0, 0, 0, 1]\n[0, 1, 0, 0, 0, 0, 0, 1]\n[0, 0, 1, 0, 0, 0, 1, 0]\n[0, 0, 1, 0, 0, 1, 0, 0]\n[0, 0, 0, 1, 1, 0, 0, 0]\n深度遍历\n1->2->4->8->5->3->6->7->\n\n\n\n## 广度优先遍历(Broad First Search) \n\n**算法思路：**\n\n1. 创建一个**队列**，用来存放每一层的顶点。\n\n2. 从初始访问顶点开始访问，将其标记为已访问，同时将其入队。\n\n3. 只要队列不空，则**重复**以下操作：\n\n   (1)队头顶点first出队。\n\n   (2)依次检查first的**所有**邻接顶点，若该邻接顶点没有被访问过，则将该邻接顶点标记为已访问，同时将其入队。\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog/20200830021.jpg)\n\n```java\npackage com.nanzx.graph;\n\nimport java.util.ArrayList;\nimport java.util.Arrays;\nimport java.util.LinkedList;\n\npublic class Graph {\n\n	private ArrayList<String> vertexList;// 顶点集合\n	private int[][] edges;// 图对应的邻接矩阵\n	private boolean[] isVisited;// 记录某个顶点是否被访问\n\n	public static void main(String[] args) {\n		String Vertexs[] = { \"1\", \"2\", \"3\", \"4\", \"5\", \"6\", \"7\", \"8\" };\n\n		// 创建图对象\n		Graph graph = new Graph(Vertexs.length);\n		// 循环的添加顶点\n		for (String vertex : Vertexs) {\n			graph.insertVertex(vertex);\n		}\n\n		// 更新边的关系\n		graph.insertEdge(0, 1, 1);\n		graph.insertEdge(0, 2, 1);\n		graph.insertEdge(1, 3, 1);\n		graph.insertEdge(1, 4, 1);\n		graph.insertEdge(3, 7, 1);\n		graph.insertEdge(4, 7, 1);\n		graph.insertEdge(2, 5, 1);\n		graph.insertEdge(2, 6, 1);\n		graph.insertEdge(5, 6, 1);\n\n		// 显示一把邻结矩阵\n		graph.showGraph();\n\n		System.out.println(\"广度优先!\");\n		graph.bfs(0); // [1->2->3->4->5->6->7->8]\n	}\n\n	// 构造器\n	public Graph(int n) {\n		vertexList = new ArrayList<String>();\n		edges = new int[n][n];\n		isVisited = new boolean[n];\n	}\n\n	// 插入顶点\n	public void insertVertex(String vertex) {\n		vertexList.add(vertex);\n	}\n\n	// 添加边\n	public void insertEdge(int v1, int v2, int weight) {\n		edges[v1][v2] = weight;\n		edges[v2][v1] = weight;\n	}\n\n	// 广度优先遍历\n	public void bfs(int i) {\n		LinkedList<Integer> queue = new LinkedList<Integer>();\n		isVisited[i] = true;\n		queue.addLast(i);\n		while (!queue.isEmpty()) {\n			int first = (Integer) queue.removeFirst();\n			System.out.print(vertexList.get(first) + \"->\");\n			for (int j = first + 1; j < vertexList.size(); j++) {\n				if (edges[first][j] > 0 && isVisited[j] == false) {\n					queue.addLast(j);\n					isVisited[j] = true;\n				}\n			}\n		}\n	}\n\n	// 显示图对应的矩阵\n	public void showGraph() {\n		for (int[] e : edges) {\n			System.out.println(Arrays.toString(e));\n		}\n	}\n}\n```\n\n**运行结果：**\n\n[0, 1, 1, 0, 0, 0, 0, 0]\n[1, 0, 0, 1, 1, 0, 0, 0]\n[1, 0, 0, 0, 0, 1, 1, 0]\n[0, 1, 0, 0, 0, 0, 0, 1]\n[0, 1, 0, 0, 0, 0, 0, 1]\n[0, 0, 1, 0, 0, 0, 1, 0]\n[0, 0, 1, 0, 0, 1, 0, 0]\n[0, 0, 0, 1, 1, 0, 0, 0]\n广度优先!\n1->2->3->4->5->6->7->8->\n\n\n\n找了一篇思路图解不错的博客帮助理解：[CSDN 图的广度优先搜索（BFS）和深度优先搜索（DFS）算法解析](https://blog.csdn.net/weixin_40953222/article/details/80544928?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-2.channel_param)', '2021-02-02 20:59:39', '201710214632');
INSERT INTO `note` VALUES (10, '测试添加笔记', '![d2d43258cf.jpg](1)', '2021-02-03 23:46:25', '201710214632');
INSERT INTO `note` VALUES (11, '测试添加笔记2', '![德玛西亚](https://cdn.jsdelivr.net/gh/839777408/tupian/img/wp8.jpg)', '2021-02-03 23:48:04', '201710214632');
INSERT INTO `note` VALUES (13, 'Mybatis问题解决', '# There is no getter for property\n\n前两天工作中遇到这个异常，一开始还以为是实体类漏写set/get方法，经排查不是。\n\n**异常**大概如下：\n\n```java\norg.mybatis.spring.MyBatisSystemException: nested exception is org.apache.ibatis.reflection.ReflectionException: There is no getter for property named \'user\' in \'class top.nanzx.entity.User\'\n```\n\ndao层代码大概如下：\n\n```java\n@Select(\"SELECT * FROM users WHERE id = #{user.id}\")\nUser getUser(User user)\n```\n\n**解决：**\n\n```java\n@Select(\"SELECT * FROM users WHERE id = #{user.id}\")\nUser getUser(@Param(\"user\")User user)\n```\n\n当时有点迷惑平时写demo根本不用加**@Param注解**，回来测试后得出如下结论（id是参数user的一个属性）：\n\n- 如果SQL语句中使用`#{user.id}`时，参数必须加@Param注解\n- 如果SQL语句中使用`#{id}`时，参数可以不加@Param注解\n- 如果参数有多个，则参数需加@Param注解\n\n---\n\n\n\n# 驼峰命名配置开启后没生效\n\n```properties\n#开启驼峰命名转换\nmybatis.configuration.map-underscore-to-camel-case=true\n```\n\n**异常：**\n\n```java\nList<User> users = userService.getAllUsers();\nsystem.out.println(users);\n```\n\n可以看到控制台显示mybatis查询成功，有打印出SQL语句和查询结果，但是users这个集合是null。\n\n于是我猜测是没有成功将查询结果封装进对象里，但是我已经配置好了自动转换驼峰命名。\n\n**解决：**\n\n经过百度，发现可能是因为项目配置了多数据源，mybatis不知道配置哪个数据源，而自定义的sqlSessionFactory默认不会加载mybatis配置。\n\n所以我们需要手动将mybatis配置注册到sqlSessionFactory中：\n\n```java\n    @Bean\n    @ConfigurationProperties(prefix = \"mybatis.configuration\")\n    public org.apache.ibatis.session.Configuration globalConfiguration(){\n        return new org.apache.ibatis.session.Configuration();\n    }\n\n    @Bean(name = \"igmSqlSessionFactory\")\n    public SqlSessionFactory igmSqlSessionFactory(@Qualifier(\"igmDataSource\") DataSource igmDataSource,org.apache.ibatis.session.Configuration configuration) throws Exception {\n        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();\n        sessionFactory.setDataSource(igmDataSource);\n        sessionFactory.setConfiguration(configuration);\n        return sessionFactory.getObject();\n    }\n```\n\n这是官网关于MyBatis-Spring-Boot-Starte的一段翻译：\n\n>MyBatis-Spring-Boot-Starter将：\n>\n>- 自动检测现有的 `DataSource`\n>- 将`DataSource`作为输入使用并通过`SqlSessionFactoryBean`创建和注册一个`SqlSessionFactory`实例\n>- 将创建并注册一个从`SqlSessionFactory`中获取的`SqlSessionTemplate`实例\n>- 自动扫描您的映射器，将它们链接到`SqlSessionTemplate`并将它们注册到Spring上下文中，以便可以将它们注入到您的bean中\n\n\n\n# 控制台不打印SQL语句及参数问题\n\napplication.yml中配置：\n\n```yaml\nlogging:\n  level:\n    top.nanzx.dao: debug\n```\n\n\n\n\n\n# 非法参数异常： argument type mismatch\n\n![](https://cdn.jsdelivr.net/gh/839777408/tupian/blog2/20210127232544.png)\n\n我的Dao层：\n\n```java\n    List<ShowCourse> showCourse();\n```\n\nShowCourse（使用了Lombok插件）：\n\n```java\n@Data\n@AllArgsConstructor\npublic class ShowCourse {\n\n    private Course course;\n\n    private String type;//推荐、热门、最新\n}\n```\n\n解决：多加一个@NoArgsConstructor\n\n\n\n# 基于注解的多表查询\n\n[CSDN MyBatis学习总结（十）---基于注解的多表查询（一对一，一对多，多对多）](https://blog.csdn.net/qq_40348465/article/details/84718602?utm_medium=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.not_use_machine_learn_pai&depth_1-utm_source=distribute.pc_relevant.none-task-blog-BlogCommendFromMachineLearnPai2-1.not_use_machine_learn_pai)\n\n\n\n# order by注入问题\n\n原Dao语句如下：\n\n```java\n    @Select(\"SELECT * FROM note WHERE no = #{no} ORDER BY #{prop} #{order}\")\n    List<Note> getNotes(@Param(\"no\")String no, @Param(\"prop\")String prop, @Param(\"order\")String order);\n```\n\n这时调用sql语句会报如下异常：\n\n```java\ncom.alibaba.druid.sql.parser.ParserException: syntax error, error in :\'RDER BY ? ?\n ) tmp_count\', expect RPAREN, actual QUES pos 68, line 2, column 44, token QUES\n```\n\n查了一下才知道：\n\n**（1）使用#运算符，Mybatis会将传入的对象当成一个字符串，在进行变量替换时会加上引号，所以order by语句，替换后就变成了下面的样子**\n\n```sql\nSELECT * FROM note ORDER BY \'no\' \'desc\';\n```\n\n虽然不会报错，但也**不能正确排序**。\n\n**（2）使用$运算符，Mybatis不会进行预编译，直接把值传进去，无法防止sql注入，当我们需要传字段的名称时，可以考虑使用$符号，但在后台需要进行数据校验，才能在一定程度上防止sql注入。**', '2021-02-10 14:37:46', '201710214632');

-- ----------------------------
-- Table structure for period
-- ----------------------------
DROP TABLE IF EXISTS `period`;
CREATE TABLE `period`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `period_id` int(11) NOT NULL,
  `period_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 49 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of period
-- ----------------------------
INSERT INTO `period` VALUES (16, 40, 1, 1, '测试');
INSERT INTO `period` VALUES (17, 40, 1, 2, '德玛西亚');
INSERT INTO `period` VALUES (18, 40, 1, 3, '大青蛙');
INSERT INTO `period` VALUES (48, 40, 2, 1, '2');

-- ----------------------------
-- Table structure for select_course
-- ----------------------------
DROP TABLE IF EXISTS `select_course`;
CREATE TABLE `select_course`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `squad` varchar(25) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 75 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of select_course
-- ----------------------------
INSERT INTO `select_course` VALUES (48, 36, '物联网172');
INSERT INTO `select_course` VALUES (49, 36, '网络172');
INSERT INTO `select_course` VALUES (50, 35, '网络172');
INSERT INTO `select_course` VALUES (51, 35, '网络173');
INSERT INTO `select_course` VALUES (52, 35, '物联网172');
INSERT INTO `select_course` VALUES (53, 34, '网络173');
INSERT INTO `select_course` VALUES (54, 33, '物联网172');
INSERT INTO `select_course` VALUES (55, 32, '物联网172');
INSERT INTO `select_course` VALUES (56, 32, '网络172');
INSERT INTO `select_course` VALUES (57, 31, '物联网172');
INSERT INTO `select_course` VALUES (58, 31, '网络172');
INSERT INTO `select_course` VALUES (59, 31, '网络173');
INSERT INTO `select_course` VALUES (60, 30, '物联网172');
INSERT INTO `select_course` VALUES (61, 29, '网络172');
INSERT INTO `select_course` VALUES (62, 29, '网络173');
INSERT INTO `select_course` VALUES (63, 28, '网络173');
INSERT INTO `select_course` VALUES (70, 40, '网络172');
INSERT INTO `select_course` VALUES (71, 40, '网络173');
INSERT INTO `select_course` VALUES (72, 40, '物联网172');

-- ----------------------------
-- Table structure for show_course
-- ----------------------------
DROP TABLE IF EXISTS `show_course`;
CREATE TABLE `show_course`  (
  `id` int(11) NOT NULL,
  `course_id` int(11) NOT NULL,
  `type` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of show_course
-- ----------------------------
INSERT INTO `show_course` VALUES (1, 31, 'recommend');
INSERT INTO `show_course` VALUES (2, 29, 'recommend');
INSERT INTO `show_course` VALUES (3, 30, 'recommend');
INSERT INTO `show_course` VALUES (4, 28, 'recommend');
INSERT INTO `show_course` VALUES (5, 33, 'recommend');
INSERT INTO `show_course` VALUES (6, 35, 'recommend');
INSERT INTO `show_course` VALUES (7, 40, 'hot');
INSERT INTO `show_course` VALUES (8, 36, 'hot');
INSERT INTO `show_course` VALUES (9, 29, 'hot');
INSERT INTO `show_course` VALUES (10, 33, 'hot');
INSERT INTO `show_course` VALUES (11, 34, 'hot');
INSERT INTO `show_course` VALUES (12, 31, 'hot');
INSERT INTO `show_course` VALUES (13, 28, 'new');
INSERT INTO `show_course` VALUES (14, 35, 'new');
INSERT INTO `show_course` VALUES (15, 40, 'new');
INSERT INTO `show_course` VALUES (16, 29, 'new');
INSERT INTO `show_course` VALUES (17, 33, 'new');
INSERT INTO `show_course` VALUES (18, 32, 'new');

-- ----------------------------
-- Table structure for student
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student`  (
  `no` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `squad` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`no`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('201710214629', '谢沛帮', '男', '119', '物联网172', '信息科学于技术学院', '123456');
INSERT INTO `student` VALUES ('201710214632', '许卓楠', '男', '13434985993', '网络173', '信息科学与技术学院', '123456');
INSERT INTO `student` VALUES ('201710214633', '翟广鑫', '男', '110', '网络172', '信息科学与技术学院', '123456');
INSERT INTO `student` VALUES ('201710214634', '钟平基', '男', '110', '网络173', '信息科学与技术学院', '123456');

-- ----------------------------
-- Table structure for teacher
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher`  (
  `no` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `name` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `sex` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `telephone` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `department` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(15) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('20100315', '刘磊安', '男', '12345678911', '信息科学与技术学院', '123456');

-- ----------------------------
-- Table structure for unit
-- ----------------------------
DROP TABLE IF EXISTS `unit`;
CREATE TABLE `unit`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `course_id` int(11) NOT NULL,
  `unit_id` int(11) NOT NULL,
  `unit_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 60 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of unit
-- ----------------------------
INSERT INTO `unit` VALUES (48, 40, 1, 'sql注入');
INSERT INTO `unit` VALUES (49, 40, 2, '文件上传');
INSERT INTO `unit` VALUES (50, 40, 3, '解密');
INSERT INTO `unit` VALUES (51, 40, 4, '仍无法');
INSERT INTO `unit` VALUES (52, 40, 5, '强无敌驱动器');
INSERT INTO `unit` VALUES (58, 36, 1, '第一单元');
INSERT INTO `unit` VALUES (59, 36, 2, '第三单元');

SET FOREIGN_KEY_CHECKS = 1;
