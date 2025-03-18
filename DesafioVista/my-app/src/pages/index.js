import Navbar from "./navbar";
import TopSec from "./sections/topSec";
import JoelSec from "./sections/joelSec";
import Footer from "./footer";
import './style.css'
import LakewoodSec from "./sections/lakewoodSec";
import BottomAnnouncement from "./bottomAnnouncement";
import ServiceTimeSec from "./sections/serviceTimeSec";
import WhatsHappeningSec from "./sections/whatsHappeningSec";

export default function Home() {
  return (
    <>
      <Navbar></Navbar>
      <div className="body">
        <TopSec></TopSec>
        <JoelSec></JoelSec>
        <LakewoodSec></LakewoodSec>
        <ServiceTimeSec></ServiceTimeSec>
        <WhatsHappeningSec></WhatsHappeningSec>
      </div>
      <BottomAnnouncement></BottomAnnouncement>
      <Footer></Footer>
    </>
  );
}
